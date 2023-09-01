package pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record BookingRequestDto (
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}
