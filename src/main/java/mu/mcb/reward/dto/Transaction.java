package mu.mcb.reward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("CustomerId")
    private String customerId;
    @JsonProperty("RewardSummaryId")
    private String rewardSummaryId;
    @JsonProperty("RewardName")
    private String rewardName;
    @JsonProperty("RewardType")
    private String rewardType;
    @JsonProperty("RewardPoints")
    private String rewardPoints;
    @JsonProperty("RewardStatus")
    private String rewardStatus;
    @JsonProperty("RewardExpiry")
    private String rewardExpiry;
    @JsonProperty("DateRewardEarned")
    private String dateRewardEarned;
    @JsonProperty("TrxCategory")
    private String trxCategory;
    @JsonProperty("TrxCcy")
    private String trxCcy;
    @JsonProperty("TrxAmount")
    private String trxAmount;
    @JsonProperty("TrxReference")
    private String trxReference;
    @JsonProperty("Points")
    private String points;
    @JsonProperty("Active")
    private String active;
}