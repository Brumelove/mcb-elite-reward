package mu.mcb.reward.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private Integer rewardSummaryId;
    private String rewardName;
    private String rewardType;
    private Double rewardPoints;
    private String rewardStatus;
    private LocalDateTime rewardExpiry;
    private Date dateRewardEarned;
    private String trxCategory;
    private String trxCcy;
    private Double trxAmount;
    private String trxReference;
    private Boolean active;
}
