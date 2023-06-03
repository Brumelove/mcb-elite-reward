
package mu.mcb.reward.entity;

import jakarta.persistence.*;
import lombok.*;
import mu.mcb.reward.enums.TierType;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reward_summary")
public class RewardSummaryEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String userId;

    private Integer rewardId;

    private Double totalPoints;

    private Integer cashedAmount;
    private String tier ;

}
