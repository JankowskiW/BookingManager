package pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RoomGroupRequestDto(
        @NotBlank(message = "{room-group.name.not-blank}")
        String name,
        @NotBlank(message = "{room-group.description.not-blank}")
        String description,
        @NotNull(message = "{room-group.available.not-null}")
        boolean available
) {}