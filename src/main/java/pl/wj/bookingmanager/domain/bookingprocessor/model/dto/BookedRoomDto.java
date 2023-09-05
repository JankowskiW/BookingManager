package pl.wj.bookingmanager.domain.bookingprocessor.model.dto;

import lombok.Builder;

@Builder
public record BookedRoomDto(
        long id,
        String name,
        String description,
        String location,
        boolean available
) { }
