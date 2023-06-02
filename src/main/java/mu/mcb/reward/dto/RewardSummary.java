
package mu.mcb.reward.dto;

import jakarta.persistence.*;
import lombok.*;
import mu.mcb.reward.enums.TierType;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RewardSummary {
    private int totalPoints = 5;
    @Enumerated(EnumType.STRING)
    private TierType tier = TierType.TIER1;
}
