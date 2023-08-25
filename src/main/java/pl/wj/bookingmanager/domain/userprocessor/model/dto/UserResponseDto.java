package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(long id, String username, String phoneNumber, String emailAddress) {
}
