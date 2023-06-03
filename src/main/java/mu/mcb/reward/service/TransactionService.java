package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.Transaction;
import mu.mcb.reward.dto.TransactionRequest;
import mu.mcb.reward.entity.CategoryEntity;
import mu.mcb.reward.entity.RewardDetailsEntity;
import mu.mcb.reward.entity.RewardSummaryEntity;
import mu.mcb.reward.entity.TierEntity;
import mu.mcb.reward.repository.CategoryRepository;
import mu.mcb.reward.repository.RewardDetailsRepository;
import mu.mcb.reward.repository.RewardSummaryRepository;
import mu.mcb.reward.repository.TierRepository;
import mu.mcb.reward.utilities.UniqueReferenceGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final RewardDetailsRepository rewardDetailsRepository;
    private final UniqueReferenceGenerator uniqueReferenceGenerator;

    private final RewardSummaryRepository rewardSummaryRepository;
    private final CategoryRepository categoryRepository;
    private final TierRepository tierRepository;

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

        System.out.println(transaction.getTrxCategory());

        // get the points multiplier
        CategoryEntity categoryEntity = categoryRepository.findByCategory(transactionRequest.getCategory());

        Double points = categoryEntity.getPoints_multiplier() * Double.valueOf(transactionRequest.getAmount());
        transaction.setPoints(String.valueOf(points));

        rewardDetailsEntity.setRewardPoints(points);

        // get the tier based on points
        TierEntity tierEntity = tierRepository.findTierByPoints(points);

        // check if reward summary exists for this user
        Optional<RewardSummaryEntity> rewardSummaryEntity = rewardSummaryRepository.getByUserId(transaction.getCustomerId());


        if (rewardSummaryEntity.isEmpty()){
            RewardSummaryEntity rewardSummaryEntityNew = new RewardSummaryEntity();
            rewardSummaryEntityNew.setUserId(transactionRequest.getCustomerId());
            rewardSummaryEntityNew.setTier(tierEntity.getTier());
            rewardSummaryEntityNew.setTotalPoints(points);
            rewardSummaryRepository.save(rewardSummaryEntityNew);
        }else{
            Double cumulativePoints = points + rewardSummaryEntity.get().getTotalPoints();
            RewardSummaryEntity rewardSummaryEntityNew = new RewardSummaryEntity();
            rewardSummaryEntityNew.setUserId(transactionRequest.getCustomerId());
            rewardSummaryEntityNew.setTier(tierEntity.getTier());
            rewardSummaryEntityNew.setTotalPoints(cumulativePoints);
            rewardSummaryEntityNew.setId(rewardSummaryEntity.get().getId());
            rewardSummaryRepository.save(rewardSummaryEntityNew);
        }




        transaction.setTrxReference(reference);
        return transaction; // to return points and reference
    }

//    method to get transactions
//    public Object getTransactionList(TransactionRequest transactionRequest) {
//    }




}
