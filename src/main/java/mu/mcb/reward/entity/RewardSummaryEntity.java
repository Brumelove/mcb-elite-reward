
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
    @Column
    private String userId;
    @Column
    private Integer rewardId;
    @Column
    private Integer totalPoints;
    @Column
    private Integer cashedAmount;
    private String tier ;

}
