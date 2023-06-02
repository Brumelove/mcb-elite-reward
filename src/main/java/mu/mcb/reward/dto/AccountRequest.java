package mu.mcb.reward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Brume
 */
@Getter
@Setter
public class AccountRequest {
    @JsonProperty("AccountType")
    private String accountType;
    @JsonProperty("Currency")
    private String currency;
}
