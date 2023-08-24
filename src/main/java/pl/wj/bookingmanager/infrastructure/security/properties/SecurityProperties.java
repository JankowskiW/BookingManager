package pl.wj.bookingmanager.infrastructure.security.properties;

import lombok.Builder;

@Builder
public record SecurityProperties(String secretKey, long expirationDays, String issuer) {
}
