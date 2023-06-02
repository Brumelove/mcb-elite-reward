package mu.mcb.reward.mapper;

import jakarta.persistence.Access;
import mu.mcb.reward.dto.Account;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.entity.AccountEntity;
import mu.mcb.reward.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Brume
 */
@Mapper(componentModel = "spring")
public interface RewardsMapper {

    CustomerEntity mapDtoToEntity(Customer source);

    AccountEntity mapDtoToEntity(Account source);

    List<AccountEntity> mapDtoListToEntity(List<Account> source);
    Account mapEntityToDto(AccountEntity source);
    Customer mapEntityToDto(CustomerEntity source);
}
