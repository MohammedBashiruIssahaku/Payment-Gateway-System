package Bashiru.com.Payment.Gateway.System.Config;

import Bashiru.com.Payment.Gateway.System.Services.CreateAccessToken;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the MTN MoMo API integration.
 * Sets up a Feign request interceptor to include required headers
 * (authorization, environment, and subscription key) in every API request.
 */
@Configuration
@RequiredArgsConstructor
public class MomoApiConfig
{
    private final CreateAccessToken createtoken;

    /**
     * Defines a Feign request interceptor to add headers to outgoing API requests.
     *
     * <p>Headers added:</p>
     * - Authorization: Bearer token obtained from {@link CreateAccessToken#Token()}
     * - X-Target-Environment: Specifies the target environment (sandbox in this case).
     * - Ocp-Apim-Subscription-Key: Unique subscription key for API access.
     *
     * @return a configured {@link RequestInterceptor} instance
     */
    @Bean
    RequestInterceptor requestInterceptor()
    {
        return requestTemplate -> requestTemplate
                .header("Authorization", "Bearer "+ createtoken.Token() )
                .header("X-Target-Environment", "sandbox")
                .header("Ocp-Apim-Subscription-Key", "60d019174b8b449eb70cea8e24e3a5e6");
    }

}
