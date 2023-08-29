package pl.wj.bookingmanager.domain.userprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.domain.userprocessor.model.UserMapper;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserUpdateRequestDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceAlreadyExistsException;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class UserProcessorService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserSecurityDto getUserSecurityDtoByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User with username " + username + " does not exist"));
        return UserMapper.toUserSecurityDto(UserMapper.toCustomUserDetails(user));
    }

    public Page<UserResponseDto> getUsers(Pageable pageable) {
        return UserMapper.toUserResponseDtoPage(userRepository.findAll(pageable));
    }

    public Page<UserResponseDto> getArchivedUsers(Pageable pageable) {
        return UserMapper.toUserResponseDtoPage(userRepository.findAllByArchived(true, pageable));
    }

    public Page<UserResponseDto> getActiveUsers(Pageable pageable) {
        return UserMapper.toUserResponseDtoPage(userRepository.findAllByArchived(false, pageable));
    }

    public UserResponseDto addUser(UserRegisterRequestDto userRegisterRequestDto) {
        throwIfNewUserExists(userRegisterRequestDto);
        String encodedPassword = passwordEncoder.encode(userRegisterRequestDto.password());
        User user = UserMapper.toUser(userRegisterRequestDto, encodedPassword);
        user = userRepository.save(user);
        return UserMapper.toUserResponseDto(user);
    }

    public UserResponseDto updateUser(long id, UserUpdateRequestDto userUpdateRequestDto) {
        throwIfUpdatedUserExists(id, userUpdateRequestDto);
        String encodedPassword = passwordEncoder.encode(userUpdateRequestDto.password());
        User user = UserMapper.toUser(id, userUpdateRequestDto, encodedPassword);
        user = userRepository.save(user);
        return UserMapper.toUserResponseDto(user);
    }

    private void throwIfNewUserExists(UserRegisterRequestDto userRegisterRequestDto) {
        if (userRepository.existsByUsername(userRegisterRequestDto.username()))
            throw new ResourceAlreadyExistsException("User with username " + userRegisterRequestDto.username() + " already exists");
        if (userRepository.existsByEmailAddress(userRegisterRequestDto.emailAddress()))
            throw new ResourceAlreadyExistsException("User with email address " + userRegisterRequestDto.emailAddress() + " already exists");
    }

    private void throwIfUpdatedUserExists(long id, UserUpdateRequestDto userUpdateRequestDto) {
        if (userRepository.existsByUsernameAndIdIsNot(userUpdateRequestDto.username(), id))
            throw new ResourceAlreadyExistsException("User with username " + userUpdateRequestDto.username() + " already exists");
        if (userRepository.existsByEmailAddressAndIdIsNot(userUpdateRequestDto.emailAddress(), id))
            throw new ResourceAlreadyExistsException("User with email address " + userUpdateRequestDto.emailAddress() + " already exists");
    }
}
