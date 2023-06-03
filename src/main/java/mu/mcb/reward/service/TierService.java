package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.entity.TierEntity;
import mu.mcb.reward.repository.TierRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TierService {
    private final TierRepository tierRepository;

    public TierEntity findTierByPoints (Double points) {
        return tierRepository.findTierByPoints(points);
    }

}
