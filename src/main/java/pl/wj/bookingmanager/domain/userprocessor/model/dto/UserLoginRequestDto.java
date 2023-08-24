package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import lombok.Builder;

@Builder
public record UserLoginRequestDto(
        // TODO: Make field validation using jakarta.validation
//        @NotBlank(message = "{user.username.not-blank}")
        String username,
//        @NotBlank(message = "{user.password.not-blank}")
        String password) {}
