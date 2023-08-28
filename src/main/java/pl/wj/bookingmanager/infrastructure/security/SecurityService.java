package pl.wj.bookingmanager.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.userprocessor.UserRepository;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserLoginRequestDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;
import pl.wj.bookingmanager.infrastructure.security.model.dto.JwtResponseDto;
import pl.wj.bookingmanager.infrastructure.security.properties.SecurityProperties;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SecurityService {
    private final AuthenticationManager authenticationManager;
    private final SecurityProperties securityProperties;
    private final UserRepository userRepository;


    public pl.wj.bookingmanager.domain.userprocessor.model.User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<pl.wj.bookingmanager.domain.userprocessor.model.User> user = Optional.empty();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            user = userRepository.findByUsername(auth.getName());
        }
        if (user.isPresent()) return user.get();
        throw new ResourceNotFoundException("Cannot find authenticated user id in database");
    }

    public JwtResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        User user = getAuthenticatedUser(userLoginRequestDto.username(), userLoginRequestDto.password());
        return JwtResponseDto.builder()
                .token(createToken(user))
                .username(user.getUsername())
                .build();
    }

    private User getAuthenticatedUser(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return (User) authentication.getPrincipal();
    }

    private String createToken(User user) {
        Instant now = Instant.now();
        return JWT.create()
                .withSubject(user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(now.plus(Duration.ofDays(securityProperties.expirationDays())))
                .withIssuer(securityProperties.issuer())
                .sign(Algorithm.HMAC256(securityProperties.secretKey()));
    }
}
