package mu.mcb.reward.api.client;

import mu.mcb.reward.configuration.FeignClientInterceptor;
import mu.mcb.reward.dto.Account;
import mu.mcb.reward.dto.AccountRequest;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.CustomerRequest;
import mu.mcb.reward.entity.AccountEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "${mcb-innov-app.base-url}", url = "${mcb-innov-app.base-url}",
        configuration = FeignClientInterceptor.class)
public interface InnovAppClient {

    @PostMapping(value = "customers", produces = {"application/json"})
    ResponseEntity<Void> createCustomer(@RequestBody CustomerRequest request );

    @GetMapping(value = "customers/{customerId}", produces = {"application/json"})
    ResponseEntity<CustomerRequest> getCustomersById(@PathVariable String customerId );

    @GetMapping(value = "customers", produces = {"application/json"})
    ResponseEntity<List<Customer>> getCustomers( );

    @GetMapping(value = "accounts", produces = {"application/json"})
    ResponseEntity<List<Account>> getAccounts() ;

    @PostMapping(value = "accounts", produces = {"application/json"})
    ResponseEntity<Void> createAccounts(@RequestBody AccountRequest account) ;

    @GetMapping(value = "customers/{customerId}/Accounts", produces = {"application/json"})
    ResponseEntity<List<Account>> getCustomerAccounts(@PathVariable String customerId) ;

    @PostMapping(value = "{versionNumber}/{domain}/{serviceName}", produces = {"application/json"})
    ResponseEntity<Object> postProcessMqReqV2(@PathVariable("versionNumber") String versionNumber,
                                              @PathVariable("domain") String domain, @PathVariable("serviceName")
                                              String serviceName, Object processMqReqPostRequestBody);
}