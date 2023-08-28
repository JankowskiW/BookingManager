package pl.wj.bookingmanager.domain.userprocessor.model.dto;

import lombok.Builder;

@Builder
public record UserSecurityDto(long id, String username, String password) {
}
