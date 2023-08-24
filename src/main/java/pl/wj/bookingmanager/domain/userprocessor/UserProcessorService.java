package pl.wj.bookingmanager.domain.userprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.domain.userprocessor.model.UserMapper;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;

@Service
@RequiredArgsConstructor
public class UserProcessorService {
    private final UserRepository userRepository;
    public UserSecurityDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Resource not found exception"));    // TODO: Make custom exceptions handler
        return UserMapper.toUserSecurityDto(UserMapper.toCustomUserDetails(user));
    }
}
