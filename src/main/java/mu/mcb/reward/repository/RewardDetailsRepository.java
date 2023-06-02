package mu.mcb.reward.repository;

import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.entity.RewardDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Brume
 */
public interface RewardDetailsRepository extends JpaRepository<RewardDetailsEntity, String> {
}
