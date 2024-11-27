package Bashiru.com.Payment.Gateway.System.Clients;

import Bashiru.com.Payment.Gateway.System.DTO.AccessTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "momo-api-auth",
        url = "https://sandbox.momodeveloper.mtn.com/remittance"

)
public interface MomoAuthClient
{
     @PostMapping("/token/")
     AccessTokenDto getAccessToken(@RequestHeader("Authorization")String authorization, @RequestHeader("Ocp-Apim-Subscription-Key") String subscriptionKey);
}
