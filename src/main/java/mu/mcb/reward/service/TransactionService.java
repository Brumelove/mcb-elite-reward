package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.Transaction;
import mu.mcb.reward.dto.TransactionRequest;
import mu.mcb.reward.entity.CategoryEntity;
import mu.mcb.reward.entity.RewardDetailsEntity;
import mu.mcb.reward.entity.RewardSummaryEntity;
import mu.mcb.reward.entity.TierEntity;
import mu.mcb.reward.enums.SubCategoryType;
import mu.mcb.reward.enums.TierType;
import mu.mcb.reward.repository.CategoryRepository;
import mu.mcb.reward.repository.RewardDetailsRepository;
import mu.mcb.reward.repository.TierRepository;
import mu.mcb.reward.utilities.UniqueReferenceGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final RewardDetailsRepository rewardDetailsRepository;
    private final UniqueReferenceGenerator uniqueReferenceGenerator;
    private final RewardsService rewardsService;
    private final TierService tierService;

    public Transaction postTransaction (TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        RewardDetailsEntity rewardDetailsEntity = new RewardDetailsEntity();
        int numberOfDaysToAdd = 1000;

        // unique FT reference
        String reference = uniqueReferenceGenerator.generateUniqueReference();
        rewardDetailsEntity.setTrxReference(reference);

        rewardDetailsEntity.setTrxAmount(transactionRequest.getAmount());
        rewardDetailsEntity.setTrxCategory(transactionRequest.getCategory());
        rewardDetailsEntity.setActive(true);

        LocalDateTime currentDateTime = LocalDateTime.now();
        rewardDetailsEntity.setRewardExpiry(currentDateTime.plusDays(numberOfDaysToAdd));
        rewardDetailsEntity.setDateRewardEarned(new java.util.Date());
        rewardDetailsEntity.setTrxCcy("MUR");

        rewardDetailsRepository.save(rewardDetailsEntity);

        // get the points multiplier
        var categoryEntity = SubCategoryType.getSubCategory(transactionRequest.getCategory());
        Double points = categoryEntity.getPointsMultiplier() * transactionRequest.getAmount();
        transaction.setPoints(String.valueOf(points));

        rewardDetailsEntity.setRewardPoints(points);

        // get the tier based on points
        var tierType = tierService.findTierByPoints(points);
        // check if reward summary exists for this user
      var rewardSummaryEntity = rewardsService.getRewardsByCustomerId(transaction.getCustomerId());

        if (rewardSummaryEntity == null){
            RewardSummaryEntity rewardSummaryEntityNew = new RewardSummaryEntity();
            rewardSummaryEntityNew.setUserId(transactionRequest.getCustomerId());
            rewardSummaryEntityNew.setTier(tierType.getTier());
            rewardSummaryEntityNew.setTotalPoints(points);
            var response = rewardsService.createRewards(rewardSummaryEntityNew);
            rewardDetailsEntity.setRewardSummaryId(response.getId());
        }else{
            Double cumulativePoints = points + rewardSummaryEntity.getTotalPoints();
            RewardSummaryEntity rewardSummaryEntityNew = new RewardSummaryEntity();
            rewardSummaryEntityNew.setUserId(transactionRequest.getCustomerId());
            rewardSummaryEntityNew.setTier(tierType.getTier());
            rewardSummaryEntityNew.setTotalPoints(cumulativePoints);
            rewardSummaryEntityNew.setId(rewardSummaryEntity.getId());
            rewardsService.createRewards(rewardSummaryEntityNew);
        }

        transaction.setTrxReference(reference);
        return transaction; // to return points and reference
    }
}
