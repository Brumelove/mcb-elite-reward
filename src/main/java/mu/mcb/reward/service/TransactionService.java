package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.RewardSummary;
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

    public Transaction postTransaction (TransactionRequest transactionRequest) {
        var transaction =Transaction.builder();
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
        transaction.points(String.valueOf(points));

        rewardDetailsEntity.setRewardPoints(points);

        // get the tier based on points
        var tierType = TierType.findTierByPoints(points);
        // check if reward summary exists for this user
      var rewardSummaryEntity = rewardsService.getRewardsByCustomerId(transactionRequest.getCustomerId());

        if (rewardSummaryEntity == null){
            RewardSummaryEntity rewardSummaryEntityNew = new RewardSummaryEntity();
            rewardSummaryEntityNew.setUserId(transactionRequest.getCustomerId());
            rewardSummaryEntityNew.setTier(tierType.getType());
            rewardSummaryEntityNew.setTotalPoints(points);
            var response = rewardsService.createRewards(rewardSummaryEntityNew);
            rewardDetailsEntity.setRewardSummaryId(response.getId());
            transaction.rewardSummaryId(String.valueOf(response.getId()));
        }else{
            Double cumulativePoints = points + rewardSummaryEntity.getTotalPoints();
            RewardSummary rewardSummaryEntityNew = new RewardSummary();
            rewardSummaryEntityNew.setTier(tierType.getType());
            rewardSummaryEntityNew.setTotalPoints(cumulativePoints);
            rewardsService.updateRewards(transactionRequest.getCustomerId(), rewardSummaryEntityNew);
        }

        transaction.trxReference(reference);
        transaction.customerId(transactionRequest.getCustomerId())
                .active("true")
                .rewardPoints(String.valueOf(points))
                .trxAmount(String.valueOf(transactionRequest.getAmount()))
                .trxCategory(categoryEntity.getCategoryType().getCategory());

        return transaction.build(); // to return points and reference
    }
}
