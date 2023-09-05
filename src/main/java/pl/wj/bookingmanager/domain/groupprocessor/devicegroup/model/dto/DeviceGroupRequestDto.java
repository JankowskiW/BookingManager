package pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DeviceGroupRequestDto(
        @NotBlank(message = "{device-group.name.not-blank}")
        String name,
        @NotBlank(message = "{device-group.description.not-blank}")
        String description,
        @NotNull(message = "{device-group.available.not-null}")
        boolean available
) {}