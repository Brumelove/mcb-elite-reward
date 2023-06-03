package mu.mcb.reward.repository;

import mu.mcb.reward.entity.TierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TierRepository extends JpaRepository<TierEntity, String> {

    @Query(value = "select * from Tier t where :points between minimum_Points And Maximum_Points ", nativeQuery = true )
    TierEntity findTierByPoints(Double points);
}
