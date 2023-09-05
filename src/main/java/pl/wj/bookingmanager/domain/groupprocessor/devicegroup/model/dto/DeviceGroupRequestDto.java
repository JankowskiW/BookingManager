package pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto;

import lombok.Builder;

@Builder
public record DeviceGroupRequestDto(
        String name,
        String description,
        boolean available
) {}