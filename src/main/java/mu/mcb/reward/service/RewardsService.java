package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.entity.RewardSummaryEntity;
import mu.mcb.reward.enums.TierType;
import mu.mcb.reward.repository.RewardSummaryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Brume
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class RewardsService {
    private final RewardSummaryRepository repository;


    public RewardSummaryEntity getRewardsByCustomerId(String customerId) {
        return repository.getByUserId(customerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rewards doesn't exist for customer"));
    }

    public void updateRewards(String customerId, Integer pointsToRedeem, Integer cashedAmount) {
        var rewards = getRewardsByCustomerId(customerId);

        repository.save(RewardSummaryEntity.builder().id(rewards.getId())
                .cashedAmount(rewards.getCashedAmount() +cashedAmount)
                .userId(customerId).tier(rewards.getTier())
                .totalPoints(rewards.getTotalPoints() - pointsToRedeem).build());
    }

    public void createRewards(String customerId) {

        repository.save(RewardSummaryEntity.builder()
                .cashedAmount(100)
                .userId(customerId).tier(TierType.TIER1.getType())
                .totalPoints(1000)
                .build());
    }

    public void updateRewards(String customerId, String tier) {
        var rewards = getRewardsByCustomerId(customerId);

        repository.save(RewardSummaryEntity.builder().userId(customerId).tier(tier)
                .totalPoints(rewards.getTotalPoints()).build());
    }
}
