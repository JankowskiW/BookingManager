package pl.wj.bookingmanager.domain.roomprocessor.model.dto;

import lombok.Builder;

@Builder
public record RoomResponseDto (
        long id,
        String name,
        String description,
        String location,
        boolean available
) {}
