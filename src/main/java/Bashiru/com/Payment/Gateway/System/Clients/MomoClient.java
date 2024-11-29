package Bashiru.com.Payment.Gateway.System.Clients;

import Bashiru.com.Payment.Gateway.System.Config.MomoApiConfig;
import Bashiru.com.Payment.Gateway.System.DTO.AccountBalanceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
  Feign client for accessing the MTN MoMo remittance API.
  Configured with MomoApiConfig class, it communicates with the MoMo API
  to retrieve account balance details.
 **/
@FeignClient(
        name = "momo-Api",
        url = "https://sandbox.momodeveloper.mtn.com/remittance",
        configuration = MomoApiConfig.class
)
public interface MomoClient
{
    /**
     * Fetches the account balance from the Momo API
     *
     * @return an {@link AccountBalanceDto} with balance details
     */
    @GetMapping("/v1_0/account/balance")
    AccountBalanceDto balance();
}
