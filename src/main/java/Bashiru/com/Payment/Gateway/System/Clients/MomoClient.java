package Bashiru.com.Payment.Gateway.System.Clients;

import Bashiru.com.Payment.Gateway.System.Config.MomoApiConfig;
import Bashiru.com.Payment.Gateway.System.DTO.AccountBalanceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "momo-Api",
        url = "https://sandbox.momodeveloper.mtn.com/remittance",
        configuration = MomoApiConfig.class
)
public interface MomoClient
{
    @GetMapping("/v1_0/account/balance")
    AccountBalanceDto balance();
}
