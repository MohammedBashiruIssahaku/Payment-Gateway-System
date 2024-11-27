package Bashiru.com.Payment.Gateway.System.Services;

import Bashiru.com.Payment.Gateway.System.Clients.MomoAuthClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAccessToken
{
    private final MomoAuthClient auth;
    //private final AccessTokenDto access;

    public String Token()
    {
        String header = Base64.getEncoder().encodeToString(String.format("%s:%s", "ffbd2ceb-06e4-46d6-bf80-bd09ec026d9a","e43f5a49a5b34432b4089409b50f5982").getBytes());
        var Authorization = auth.getAccessToken("Basic "+header, "60d019174b8b449eb70cea8e24e3a5e6");
        log.info("Your accesstoken:  {}", Authorization);
        return Authorization.accessToken();
    }
}
