package pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto;

import lombok.Builder;

@Builder
public record RoomGroupResponseDto (
        long id,
        String name,
        String description,
        boolean available
) {}