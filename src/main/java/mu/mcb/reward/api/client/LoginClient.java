//package mu.mcb.reward.api.client;
//
//import mu.mcb.reward.configuration.FeignClientInterceptor;
//import mu.mcb.reward.dto.AuthenticationResponse;
//import mu.mcb.reward.dto.LoginRequest;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
///**
// * @author Brume
// */
//@FeignClient(value = "${mcb-innov-app.base-url}", url = "${mcb-innov-app.base-url}")
//public interface LoginClient {
//    @PostMapping(value = "auth", produces = {"application/json"})
//    ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request ) ;
//}
