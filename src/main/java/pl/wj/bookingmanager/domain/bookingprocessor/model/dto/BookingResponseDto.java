package pl.wj.bookingmanager.domain.bookingprocessor.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingResponseDto (
        long id,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        long createdBy,
        long updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
)
{}
