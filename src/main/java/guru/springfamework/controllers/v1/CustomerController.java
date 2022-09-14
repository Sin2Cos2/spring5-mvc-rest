package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers() {

        return new CustomerListDTO(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable String customerId) {

        return customerService.getCustomerById(Long.parseLong(customerId));
    }

    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {

        return customerService.createNewCustomer(customerDTO);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable String customerId,
                                      @RequestBody CustomerDTO customerDTO) {

        return customerService.saveCustomerByDTO(Long.valueOf(customerId), customerDTO);
    }

    @PatchMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable String customerId,
                                     @RequestBody CustomerDTO customerDTO) {

        return customerService.patchCustomer(Long.valueOf(customerId), customerDTO);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomerById(@PathVariable String customerId) {
        customerService.deleteCustomerById(Long.parseLong(customerId));
    }
}
