package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.entity.CategoryEntity;
import mu.mcb.reward.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Double mapCategoryAndGetPointsMultiplier (String category) {
        CategoryEntity entity = categoryRepository.findByCategory(category);
        return entity.getPoints_multiplier();
    }
}
