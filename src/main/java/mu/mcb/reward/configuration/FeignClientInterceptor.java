package mu.mcb.reward.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import mu.mcb.reward.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Brume
 */
@Component
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER="Authorization";
    private static final String TOKEN_TYPE = "Bearer";
    private  final LoginService service;

    @Bean
    public RequestInterceptor requestInterceptor() {

        return requestTemplate -> requestTemplate.header(AUTHORIZATION_HEADER, "Bearer " + service.getToken());
    }
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, service.getToken()));
        }
    }
}
