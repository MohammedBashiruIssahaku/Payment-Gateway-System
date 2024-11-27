package Bashiru.com.Payment.Gateway.System.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccessTokenDto(
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("token_type")
        String tokenType,
        @JsonProperty("expires_in")
        String expires_in
) {
}
