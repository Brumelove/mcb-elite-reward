package mu.mcb.reward.repository;

import mu.mcb.reward.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

    @Query(value = "select * from category c where c.category=:category", nativeQuery = true)
    CategoryEntity findByCategory(String category);
}
