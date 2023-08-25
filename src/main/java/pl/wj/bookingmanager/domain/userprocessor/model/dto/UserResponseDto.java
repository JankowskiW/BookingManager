package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(long id, String username, String firstName, String lastName, String phoneNumber, String emailAddress, boolean archived) {
}
