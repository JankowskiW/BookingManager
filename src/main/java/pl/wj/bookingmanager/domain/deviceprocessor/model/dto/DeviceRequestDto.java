package pl.wj.bookingmanager.domain.deviceprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DeviceRequestDto (
        @NotBlank(message = "{device.name.not-blank}")
        String name,
        @NotBlank(message = "{device.description.not-blank}")
        String description,
        @NotNull(message = "{device.available.not-null}")
        boolean available
){}
