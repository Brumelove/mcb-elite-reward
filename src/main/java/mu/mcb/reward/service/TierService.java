package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.entity.CategoryEntity;
import mu.mcb.reward.entity.TierEntity;
import mu.mcb.reward.repository.CategoryRepository;
import mu.mcb.reward.repository.TierRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TierService {

    private final TierRepository tierRepository;

//    public String getTier (String customerId, Double minimum, Double maximum) {
//        TierEntity tierEntity = tierRepository.findbyMinimumPointsAndMaximumPoints(minimum, maximum);
//        return tierEntity.getTier();
//    }

}
