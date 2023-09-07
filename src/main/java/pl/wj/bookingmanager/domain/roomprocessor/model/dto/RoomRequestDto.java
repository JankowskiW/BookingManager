package pl.wj.bookingmanager.domain.roomprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RoomRequestDto (
        @NotBlank(message = "{room.name.not-blank}")
        String name,
        @NotNull(message = "{room.description.not-null}")
        String description,
        @NotBlank(message = "{room.location.not-blank}")
        String location,
        @NotNull(message = "{room.available.not-null}")
        boolean available
) {}
