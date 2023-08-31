package pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto;

import lombok.Builder;

@Builder
public record BookedDeviceDto(
        long id,
        String name,
        String description,
        boolean available
) { }
