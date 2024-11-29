package Bashiru.com.Payment.Gateway.System.Services;

import Bashiru.com.Payment.Gateway.System.Clients.MomoAuthClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * Service class responsible for generating an access token to authenticate
 * with the MTN MoMo API.
 * Uses {@link MomoAuthClient} to communicate with the MoMo API and retrieve
 * an access token using basic authentication.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAccessToken
{
    private final MomoAuthClient auth;
    //private final AccessTokenDto access;

    /**
     * Generates an access token by calling the MoMo API.
     * Constructs the basic authentication header, sends the request, logs the
     * access token, and returns it.
     * @return the access token as a {@link String}
     */
    public String Token()
    {
        // Encode client credentials into Base64 format for Basic Auth
        String header = Base64.getEncoder().encodeToString(String.format("%s:%s", "ffbd2ceb-06e4-46d6-bf80-bd09ec026d9a","e43f5a49a5b34432b4089409b50f5982").getBytes());

        // Call the MoMo API to get the access token
        var Authorization = auth.getAccessToken("Basic "+header, "60d019174b8b449eb70cea8e24e3a5e6");

        // Log the obtained access token for debugging purposes
        log.info("Your accesstoken:  {}", Authorization);

        // Return the access token from the response
        return Authorization.accessToken();
    }
}
