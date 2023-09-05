package pl.wj.bookingmanager.domain.userprocessor.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserUpdateRequestDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static CustomUserDetails toCustomUserDetails(User user) {
        if (user == null) throw new MapperException("User is null");
        return CustomUserDetails.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .emailAddress(user.getEmailAddress())
                .archived(user.isArchived())
                .build();
    }

    public static User toUser(UserRegisterRequestDto userRegisterRequestDto, String encodedPassword) {
        if (userRegisterRequestDto == null) throw new MapperException("UserRegisterRequestDto is null");
        if (encodedPassword == null || encodedPassword.isBlank()) throw new MapperException("encodedPassword is null or blank");
        return User.builder()
                .username(userRegisterRequestDto.username())
                .password(encodedPassword)
                .firstName(userRegisterRequestDto.firstName())
                .lastName(userRegisterRequestDto.lastName())
                .phoneNumber(userRegisterRequestDto.phoneNumber())
                .emailAddress(userRegisterRequestDto.emailAddress())
                .archived(false)
                .build();
    }

    public static User toUser(long id, UserUpdateRequestDto userUpdateRequestDto, String encodedPassword) {
        if (userUpdateRequestDto == null) throw new MapperException("UserUpdateRequestDto is null");
        if (encodedPassword == null || encodedPassword.isBlank()) throw new MapperException("encodedPassword is null or blank");
        return User.builder()
                .id(id)
                .username(userUpdateRequestDto.username())
                .password(encodedPassword)
                .firstName(userUpdateRequestDto.firstName())
                .lastName(userUpdateRequestDto.lastName())
                .phoneNumber(userUpdateRequestDto.phoneNumber())
                .emailAddress(userUpdateRequestDto.emailAddress())
                .archived(userUpdateRequestDto.archived())
                .build();
    }

    public static UserResponseDto toUserResponseDto(User user) {
        if (user == null) throw new MapperException("User is null");
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .emailAddress(user.getEmailAddress())
                .archived(user.isArchived())
                .build();
    }

    public static UserSecurityDto toUserSecurityDto(CustomUserDetails customUserDetails) {
        if (customUserDetails == null) throw new MapperException("CustomUserDetails is null");
        return UserSecurityDto.builder()
                .username(customUserDetails.username())
                .password(customUserDetails.password())
                .build();
    }

    public static Page<UserResponseDto> toUserResponseDtoPage(Page<User> users) {
        if (users == null) throw new MapperException("Page<User> is null");
        return users.map(UserMapper::toUserResponseDto);
    }
}
