package guru.springfamework.api.v1.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerListDTO {
    private List<CustomerDTO> customers;
}
