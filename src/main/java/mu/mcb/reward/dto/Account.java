package mu.mcb.reward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * @author Brume
 */
@Getter
@Setter
public class Account {
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("AccountType")
    private String accountType;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("AccountName")
    private String accountName;
    @JsonProperty("Balance")
    private String balance;
    @JsonProperty("_id")
    private String id;
}
