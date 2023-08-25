package pl.wj.bookingmanager.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.userprocessor.model.CustomUserDetails;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserLoginRequestDto;
import pl.wj.bookingmanager.infrastructure.security.model.dto.JwtResponseDto;
import pl.wj.bookingmanager.infrastructure.security.properties.SecurityProperties;

import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
@Service
public class SecurityService {
    private final AuthenticationManager authenticationManager;
    private final SecurityProperties securityProperties;


    public JwtResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        CustomUserDetails customUserDetails = getAuthenticatedUser(userLoginRequestDto.username(), userLoginRequestDto.password());
        return JwtResponseDto.builder()
                .token(createToken(customUserDetails))
                .username(customUserDetails.getUsername())
                .build();
    }

    private CustomUserDetails getAuthenticatedUser(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return (CustomUserDetails) authentication.getPrincipal();
    }

    private String createToken(CustomUserDetails customUserDetails) {
        Instant now = Instant.now();
        return JWT.create()
                .withSubject(customUserDetails.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(now.plus(Duration.ofDays(securityProperties.expirationDays())))
                .withIssuer(securityProperties.issuer())
                .sign(Algorithm.HMAC256(securityProperties.secretKey()));
    }
}
