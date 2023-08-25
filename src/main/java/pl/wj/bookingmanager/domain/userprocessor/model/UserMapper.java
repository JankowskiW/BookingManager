package pl.wj.bookingmanager.domain.userprocessor.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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

    public static User toUser(CustomUserDetails customUserDetails) {
        User user = new User();
        user.setId(customUserDetails.id());
        user.setUsername(customUserDetails.username());
        user.setPassword(customUserDetails.password());
        user.setEmailAddress(customUserDetails.phoneNumber());
        user.setPhoneNumber(customUserDetails.emailAddress());
        return user;
    }

    public static UserSecurityDto toUserSecurityDto(CustomUserDetails customUserDetails) {
        return UserSecurityDto.builder()
                .username(customUserDetails.username())
                .password(customUserDetails.password())
                .build();
    }
}
