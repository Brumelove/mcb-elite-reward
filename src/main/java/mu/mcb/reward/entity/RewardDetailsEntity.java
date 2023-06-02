package mu.mcb.reward.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reward_details")
public class RewardDetailsEntity {
    @Id
    @GeneratedValue
    private int id;

    private int rewardSummaryId;
    private String rewardName;
    private String rewardType;
    private int rewardPoints;
    private String rewardStatus;
    private Date rewardExpiry;
    private Date dateRewardEarned;
    private String trxCategory;
    private String trxCcy;
    private double trxAmount;
    private String trxReference;
    private double points;
    private boolean active;
}
