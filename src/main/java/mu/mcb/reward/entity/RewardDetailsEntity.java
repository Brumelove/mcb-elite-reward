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
    private Integer id;

    @Column
    private Integer rewardSummaryId;
    @Column
    private String rewardName;
    @Column
    private String rewardType;
    private Integer rewardPoints;
    private String rewardStatus;
    private Date rewardExpiry;
    private Date dateRewardEarned;
    private String trxCategory;
    private String trxCcy;
    private Double trxAmount;
    private String trxReference;
    private Double points;
    private Boolean active;
}
