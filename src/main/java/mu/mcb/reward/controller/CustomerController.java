package mu.mcb.reward.controller;

import lombok.RequiredArgsConstructor;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerResponse;
import mu.mcb.reward.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Brume
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    private final UserService service;

    @PostMapping()
    public ResponseEntity<Customer> register( ) {
        return ResponseEntity.ok(service.createCustomer());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerInfo(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getAccountDetailsByCustomerId(customerId));
    }
}
