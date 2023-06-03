package mu.mcb.reward.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.mcb.reward.api.client.InnovAppClient;
import mu.mcb.reward.dto.AuthenticationResponse;
import mu.mcb.reward.dto.Customer;
import mu.mcb.reward.dto.LoginRequest;
import mu.mcb.reward.utilities.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Brume
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Value( "${mcb-innov-app.username}")
    private String username;
    @Value( "${mcb-innov-app.base-url}")
    private String baseUrl;

    @Value( "${mcb-innov-app.password}")
    private String password;
    public String getToken(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = baseUrl + "/auth";
        ResponseEntity<AuthenticationResponse> response
                = restTemplate.postForEntity(fooResourceUrl , new LoginRequest(username, password), AuthenticationResponse.class);
        return response.getBody().getToken();
    }

}
