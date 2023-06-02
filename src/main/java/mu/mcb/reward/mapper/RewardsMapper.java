package mu.mcb.reward.mapper;

import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.entity.CustomerEntity;
import org.mapstruct.Mapper;

/**
 * @author Brume
 */
@Mapper(componentModel = "spring")
public interface RewardsMapper {

    CustomerEntity mapDtoToEntity(Customer source);
    Customer mapEntityToDto(CustomerEntity source);
}
