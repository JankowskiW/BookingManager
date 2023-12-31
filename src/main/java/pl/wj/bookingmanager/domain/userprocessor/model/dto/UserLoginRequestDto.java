package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserLoginRequestDto(
        @NotBlank(message = "{user.username.not-blank}")
        String username,
        @NotBlank(message = "{user.password.not-blank}")
        String password) {}
