package pl.wj.bookingmanager.domain.userprocessor.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserSecurityDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static CustomUserDetails toCustomUserDetails(User user) {
        return CustomUserDetails.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .emailAddress(user.getEmailAddress())
                .build();
    }

    public static User toUser(UserRegisterRequestDto userRegisterRequestDto, String encodedPassword) {
        return User.builder()
                .username(userRegisterRequestDto.username())
                .password(encodedPassword)
                .phoneNumber(userRegisterRequestDto.phoneNumber())
                .emailAddress(userRegisterRequestDto.emailAddress())
                .build();
    }

    public static UserResponseDto toUserResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .emailAddress(user.getEmailAddress())
                .build();
    }

    public static UserSecurityDto toUserSecurityDto(CustomUserDetails customUserDetails) {
        return UserSecurityDto.builder()
                .username(customUserDetails.username())
                .password(customUserDetails.password())
                .build();
    }
}
