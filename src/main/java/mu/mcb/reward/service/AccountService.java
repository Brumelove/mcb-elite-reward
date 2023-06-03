package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.dto.RewardSummary;
import mu.mcb.reward.mapper.RewardsMapper;
import mu.mcb.reward.repository.AccountRepository;
import mu.mcb.reward.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
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
    private final RewardsService rewardsService;
    @Value( "${mcb-innov-app.points-conversion}")
    private Integer pointsConversion;


    public String createAccount(String customerId) {
        service.createAccount();
        var accounts = service.getCustomerAccounts(customerId);
        log.info("Cus {}" , accounts);
        repository.saveAll(mapper.mapDtoListToEntity(accounts));
        return "Saved successfully";
    }

    public Integer redeemPoints(String customerId, Integer points) {
        var amountInRupees = points / pointsConversion;
        rewardsService.updateRewards(customerId, points, amountInRupees);
        return amountInRupees;
    }

}
