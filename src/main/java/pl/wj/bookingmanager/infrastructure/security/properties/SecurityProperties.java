package pl.wj.bookingmanager.infrastructure.security.properties;

import lombok.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Builder
@ConfigurationProperties(prefix = "booking-manager.security")
public record SecurityProperties(String secretKey, long expirationDays, String issuer) {
}
