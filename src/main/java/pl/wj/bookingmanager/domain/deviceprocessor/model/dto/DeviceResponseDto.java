package pl.wj.bookingmanager.domain.deviceprocessor.model.dto;

import lombok.Builder;

@Builder
public record DeviceResponseDto (
        long id,
        String name,
        String description,
        boolean available
){}
