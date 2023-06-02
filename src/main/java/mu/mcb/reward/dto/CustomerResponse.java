package mu.mcb.reward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author Brume
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private String customerId;
    private String title;
    private String firstName;
    private String lastName;
    private List<Account> accounts;
    private RewardSummary rewards;
}
