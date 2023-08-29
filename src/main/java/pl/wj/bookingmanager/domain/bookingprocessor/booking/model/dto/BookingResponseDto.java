package pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingResponseDto (
        long id,
        String title,
        String description,
        LocalDateTime validFrom,
        LocalDateTime validTo
)
{}
