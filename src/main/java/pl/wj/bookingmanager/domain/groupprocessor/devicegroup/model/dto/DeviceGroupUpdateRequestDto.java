package pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto;

import lombok.Builder;

@Builder
public record DeviceGroupUpdateRequestDto (
        String name,
        String description,
        boolean available
) {}