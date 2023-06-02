package mu.mcb.reward.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.Account;
import mu.mcb.reward.dto.AccountRequest;
import mu.mcb.reward.dto.CustomerRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Brume
 */
@Slf4j
public abstract class JsonUtils {
    private JsonUtils() {
    }

    private static final ObjectMapper DEFAULT_OBJECT_MAPPER = new ObjectMapper();

    public static CustomerRequest createCustomer() {
        CustomerRequest  response = new CustomerRequest();
        try {
            response = DEFAULT_OBJECT_MAPPER.readValue(
                    new File("src/main/resources/customer1.json"), CustomerRequest.class);
        } catch (IOException e) {
            log.info("Error reading file {} ", e.getMessage());
        }
        return  response;
    }

    public static List<AccountRequest> createAccount() {
        List<AccountRequest>  response = null;
        try {
            response = DEFAULT_OBJECT_MAPPER.readValue(
                    new File("src/main/resources/accounts.json"), new TypeReference<>() {});
        } catch (IOException e) {
            log.info("Error reading file {} ", e.getMessage());
        }
        return  response;
    }

}
