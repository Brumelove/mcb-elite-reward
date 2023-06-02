package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.api.client.InnovAppClient;
import mu.mcb.reward.dto.Account;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerRequest;
import mu.mcb.reward.entity.AccountEntity;
import mu.mcb.reward.utilities.JsonUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brume
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InnovAppService {
    private  final InnovAppClient innovAppClient;
    public Customer createCustomer() {
         return innovAppClient.createCustomer(JsonUtils.createCustomer()).getBody();

    }

    public void createAccount() {
        for (Account account: JsonUtils.createAccount() ) {
           innovAppClient.createAccounts(account);
        }
    }

    public CustomerRequest getCustomersById(String customerId) {
        return innovAppClient.getCustomersById(customerId).getBody();

    }

    public List<Account> getCustomerAccounts(String customerId) {
        return innovAppClient.getCustomerAccounts(customerId)
                .getBody();

    }

    public List<Account> getAccounts() {
        return innovAppClient.getAccounts().getBody();

    }
}
