package mu.mcb.reward.repository;

import mu.mcb.reward.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Brume
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
