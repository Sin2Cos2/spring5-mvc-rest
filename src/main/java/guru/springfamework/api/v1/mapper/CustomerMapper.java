package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);

    @Mapping(target = "customerURL", source = "id", qualifiedByName = "customerURL")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Named("customerURL")
    default String setUrl(Long customerId) {
        return "/api/v1/customers/" + customerId;
    }
}
