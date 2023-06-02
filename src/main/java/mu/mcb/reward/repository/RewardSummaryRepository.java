package mu.mcb.reward.repository;

import mu.mcb.reward.entity.RewardDetailsEntity;
import mu.mcb.reward.entity.RewardSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Brume
 */
public interface RewardSummaryRepository extends JpaRepository<RewardSummaryEntity, String> {
}
