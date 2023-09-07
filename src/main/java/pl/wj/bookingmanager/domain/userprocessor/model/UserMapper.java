package pl.wj.bookingmanager.domain.userprocessor.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserUpdateRequestDto;
import pl.wj.bookingmanager.infrastructure.exception.ExceptionMessage;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static CustomUserDetails toCustomUserDetails(User user) {
        if (user == null) throw new MapperException(ExceptionMessage.getMapperMessage("null", "User"));
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
        if (userRegisterRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "UserRegisterRequestDto"));
        if (encodedPassword == null || encodedPassword.isBlank())
            throw new MapperException(ExceptionMessage.getMapperMessage("null-or-blank", "UserRegisterRequestDto"));
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
        if (userUpdateRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "UserUpdateRequestDto"));
        if (encodedPassword == null || encodedPassword.isBlank())
            throw new MapperException(ExceptionMessage.getMapperMessage("null-or-blank", "UserUpdateRequestDto"));
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
        if (user == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "User"));
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
        if (customUserDetails == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "CustomUserDetails"));
        return UserSecurityDto.builder()
                .username(customUserDetails.username())
                .password(customUserDetails.password())
                .build();
    }

    public static Page<UserResponseDto> toUserResponseDtoPage(Page<User> users) {
        if (users == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Page<User>"));
        return users.map(UserMapper::toUserResponseDto);
    }
}
