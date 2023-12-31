package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record UserUpdateRequestDto(
        @NotBlank(message = "{user.username.not-blank}")
        String username,
        @NotBlank(message = "{user.password.not-blank}")
        String password,
        @NotBlank(message = "{user.first-name.not-blank}")
        String firstName,
        @NotBlank(message = "{user.last-name.not-blank}")
        String lastName,
        @NotBlank(message = "{user.email-address.not-blank}")
        @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{user.email-address.invalid}")
        String emailAddress,
        @Pattern(regexp = "^[+]?[0-9]*$", message = "{user.phone-number.invalid}")
        String phoneNumber,
        boolean archived
) {}