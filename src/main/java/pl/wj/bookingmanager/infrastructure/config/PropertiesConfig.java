package pl.wj.bookingmanager.infrastructure.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pl.wj.bookingmanager.infrastructure.security.properties.SecurityProperties;

@Configuration
@EnableConfigurationProperties({
        SecurityProperties.class
})
public class PropertiesConfig {
}
