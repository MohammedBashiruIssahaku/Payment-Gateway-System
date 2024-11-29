package Bashiru.com.Payment.Gateway.System.Clients;

import Bashiru.com.Payment.Gateway.System.DTO.AccessTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Feign client for authenticating with the MTN MoMo API.
 * This client is used to retrieve an access token for authorization when interacting
 * with the MTN MoMo remittance services.
 */
@FeignClient(
        name = "momo-api-auth",
        url = "https://sandbox.momodeveloper.mtn.com/remittance"

)
public interface MomoAuthClient
{
     /**
      * Retrieves an access token from the MoMo API.
      *
      * @param authorization the basic authentication header
      * @param subscriptionKey the subscription key for accessing the MoMo API
      * @return an {@link AccessTokenDto} containing the access token details
      */
     @PostMapping("/token/")
     AccessTokenDto getAccessToken(@RequestHeader("Authorization")String authorization, @RequestHeader("Ocp-Apim-Subscription-Key") String subscriptionKey);
}
