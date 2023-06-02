package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.dto.RewardSummary;
import mu.mcb.reward.mapper.RewardsMapper;
import mu.mcb.reward.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author Brume
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final InnovAppService service;
    private final CustomerRepository repository;
    private final RewardsMapper mapper;

    public Customer createCustomer(String customerId) {
        var customer = service.getCustomersById(customerId);
        return mapper.mapEntityToDto(repository.save(mapper.mapDtoToEntity(customer)));
    }

    public CustomerResponse getAccountDetailsByCustomerId(String customerId) {
        var customer = service.getCustomersById(customerId);
        return CustomerResponse.builder().accounts(service.getCustomerAccounts(customerId)).title(customer.getTitle())
                .firstName(customer.getFirstName()).lastName(customer.getLastName()).customerId(customerId)
                .rewards(RewardSummary.builder().build()).build();


    }
}
