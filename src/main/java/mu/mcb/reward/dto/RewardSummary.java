
package mu.mcb.reward.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RewardSummary {
    private Double totalPoints ;

    private String tier ;
}
