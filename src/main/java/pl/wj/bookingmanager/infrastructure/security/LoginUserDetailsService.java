package pl.wj.bookingmanager.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.wj.bookingmanager.domain.userprocessor.UserProcessorService;
import pl.wj.bookingmanager.infrastructure.security.mapper.SecurityMapper;

@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {
    private final UserProcessorService userProcessorService;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return SecurityMapper.toSecurityUser(userProcessorService.getUserSecurityDtoByUsername(username));
    }
}