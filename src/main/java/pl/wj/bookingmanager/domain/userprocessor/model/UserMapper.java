package pl.wj.bookingmanager.domain.userprocessor.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserUpdateRequestDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static CustomUserDetails toCustomUserDetails(User user) {
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
        return UserSecurityDto.builder()
                .username(customUserDetails.username())
                .password(customUserDetails.password())
                .build();
    }

    public static Page<UserResponseDto> toUserResponseDtoPage(Page<User> users) {
        return users.map(UserMapper::toUserResponseDto);
    }
}
