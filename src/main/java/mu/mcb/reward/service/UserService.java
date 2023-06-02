package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.Account;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.dto.RewardSummary;
import mu.mcb.reward.entity.CustomerEntity;
import mu.mcb.reward.mapper.RewardsMapper;
import mu.mcb.reward.repository.CustomerRepository;
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
public class UserService {
    private final InnovAppService service;
    private final CustomerRepository repository;
    private final RewardsMapper mapper;

    public Customer createCustomer(String customerId) {
        var customer = service.getCustomersById(customerId).getCustomer();
        return mapper.mapEntityToDto(repository.save(mapper.mapDtoToEntity(customer)));
    }


    public CustomerResponse getAccountDetailsByCustomerId(String customerId) {
        var customer = service.getCustomersById(customerId).getCustomer();
        return CustomerResponse.builder().accounts(service.getCustomerAccounts(customerId)).title(customer.getTitle())
                .firstName(customer.getFirstName()).lastName(customer.getLastName()).customerId(customerId)
                .rewards(RewardSummary.builder().build()).build();


    }
}
