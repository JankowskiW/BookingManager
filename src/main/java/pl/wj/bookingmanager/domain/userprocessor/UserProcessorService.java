package pl.wj.bookingmanager.domain.userprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.domain.userprocessor.model.UserMapper;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserUpdateRequestDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceAlreadyExistsException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProcessorService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserSecurityDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Resource not found exception"));    // TODO: Make custom exceptions handler
        return UserMapper.toUserSecurityDto(UserMapper.toCustomUserDetails(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponseDto addUser(UserRegisterRequestDto userRegisterRequestDto) {
        if (userRepository.existsByUsername(userRegisterRequestDto.username()))
            throw new ResourceAlreadyExistsException("User with username " + userRegisterRequestDto.username() + " already exists");
        if (userRepository.existsByEmailAddress(userRegisterRequestDto.emailAddress()))
            throw new ResourceAlreadyExistsException("User with email address " + userRegisterRequestDto.emailAddress() + " already exists");
        String encodedPassword = passwordEncoder.encode(userRegisterRequestDto.password());
        User user = UserMapper.toUser(userRegisterRequestDto, encodedPassword);
        user = userRepository.save(user);
        return UserMapper.toUserResponseDto(user);
    }

    public UserResponseDto updateUser(long id, UserUpdateRequestDto userUpdateRequestDto) {
        if (userRepository.existsByUsernameAndIdIsNot(userUpdateRequestDto.username(), id))
            throw new ResourceAlreadyExistsException("User with username " + userUpdateRequestDto.username() + " already exists xzx");
        if (userRepository.existsByEmailAddressAndIdIsNot(userUpdateRequestDto.emailAddress(), id))
            throw new ResourceAlreadyExistsException("User with email address " + userUpdateRequestDto.emailAddress() + " already exists xzx");
        String encodedPassword = passwordEncoder.encode(userUpdateRequestDto.password());
        User user = UserMapper.toUser(id, userUpdateRequestDto, encodedPassword);
        user = userRepository.save(user);
        return UserMapper.toUserResponseDto(user);
    }
}
