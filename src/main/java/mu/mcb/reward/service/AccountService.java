package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.dto.RewardSummary;
import mu.mcb.reward.mapper.RewardsMapper;
import mu.mcb.reward.repository.AccountRepository;
import mu.mcb.reward.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final InnovAppService service;
    private final AccountRepository repository;
    private final RewardsMapper mapper;

    public String createAccount(String customerId) {
        service.createAccount();
        var accounts = service.getCustomerAccounts(customerId);
        log.info("Cus {}" , accounts);
        repository.saveAll(mapper.mapDtoListToEntity(accounts));
        return "Saved successfully";
    }


    public CustomerResponse getAccountDetailsByCustomerId(String customerId) {
        var customer = service.getCustomersById(customerId).getCustomer();
        return CustomerResponse.builder().accounts(service.getCustomerAccounts(customerId)).title(customer.getTitle())
                .firstName(customer.getFirstName()).lastName(customer.getLastName()).customerId(customerId)
                .rewards(RewardSummary.builder().build()).build();


    }
}
