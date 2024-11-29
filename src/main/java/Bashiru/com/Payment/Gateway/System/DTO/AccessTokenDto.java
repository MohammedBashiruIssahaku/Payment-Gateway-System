package Bashiru.com.Payment.Gateway.System.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object (DTO) for API access token responses.
 * Represents the token details returned by the MTN MoMo API, used for authenticating
 * and authorizing API requests.
 * @param accessToken the access token required for API authentication
 * @param tokenType the type of token (e.g., "Bearer")
 * @param expires_in the time (in seconds) until the token expires
 */
public record AccessTokenDto(
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("token_type")
        String tokenType,
        @JsonProperty("expires_in")
        String expires_in
) {
}
