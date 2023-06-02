package mu.mcb.reward.repository;

import mu.mcb.reward.entity.AccountEntity;
import mu.mcb.reward.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Brume
 */
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}
