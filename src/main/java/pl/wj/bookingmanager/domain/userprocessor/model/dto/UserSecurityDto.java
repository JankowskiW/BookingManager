package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import lombok.Builder;

@Builder
public record UserSecurityDto(String username, String password) {
}
