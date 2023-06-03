package mu.mcb.reward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    @JsonProperty("CustomerId")
    private String customerId;
    @JsonProperty("Amount")
    private Double amount;
    @JsonProperty("Category")
    private String category;
}