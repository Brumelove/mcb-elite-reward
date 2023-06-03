
package mu.mcb.reward.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;
import mu.mcb.reward.enums.TierType;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RewardSummary {
    private Integer totalPoints ;

    private String tier ;
}
