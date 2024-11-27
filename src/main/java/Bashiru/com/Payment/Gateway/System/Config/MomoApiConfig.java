package Bashiru.com.Payment.Gateway.System.Config;

import Bashiru.com.Payment.Gateway.System.Services.CreateAccessToken;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MomoApiConfig
{
    private final CreateAccessToken createtoken;

    @Bean
    RequestInterceptor requestInterceptor()
    {
        return requestTemplate -> requestTemplate
                .header("Authorization", "Bearer "+ createtoken.Token() )
                .header("X-Target-Environment", "sandbox")
                .header("Ocp-Apim-Subscription-Key", "60d019174b8b449eb70cea8e24e3a5e6");
    }

}
