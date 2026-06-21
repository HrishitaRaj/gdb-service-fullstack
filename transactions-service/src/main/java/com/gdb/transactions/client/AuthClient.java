package com.gdb.transactions.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthClient {

    private final RestTemplate restTemplate;

    @Value("${app.services.auth-url:http://localhost:8004}")
    private String authServiceUrl;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TokenValidationResponse {
        @JsonProperty("valid")
        private boolean isValid;
        @JsonProperty("user_id")
        private Long userId;
        @JsonProperty("login_id")
        private String loginId;
        private String role;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TokenRevocationResponse {

        @JsonProperty("revoked")
        private boolean revoked;
    }

    public TokenValidationResponse validateToken(String token) {
        String url = authServiceUrl + "/internal/v1/auth/validate-token";
        try {
            return restTemplate.postForObject(url, Map.of("token", token), TokenValidationResponse.class);
        } catch (Exception e) {
            log.error("Error validating token with Auth Service: {}", e.getMessage());
            return TokenValidationResponse.builder().isValid(false).build();
        }
    }

    public boolean isTokenRevoked(String token) {

    String url = authServiceUrl + "/internal/v1/auth/is-token-revoked";

    try {

        TokenRevocationResponse response =
                restTemplate.postForObject(
                        url,
                        Map.of("token", token),
                        TokenRevocationResponse.class
                );

        return response != null && response.isRevoked();

    } catch (Exception e) {

        log.error(
                "Error checking token revocation with Auth Service: {}",
                e.getMessage()
        );

        return false;
    }
}
}
