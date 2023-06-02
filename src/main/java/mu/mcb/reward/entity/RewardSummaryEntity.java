
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
    private int id;
    private int userId;
    private int rewardId;
    private int totalPoints;
    @Enumerated(EnumType.STRING)
    private TierType tier = TierType.TIER1;
    private Date expireOn;

}
