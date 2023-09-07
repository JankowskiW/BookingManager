package pl.wj.bookingmanager.domain.devicegroupprocessor.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.dto.DeviceGroupRequestDto;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.dto.DeviceGroupResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

public class DeviceGroupMapper {
    public static DeviceGroup toDeviceGroup(DeviceGroupRequestDto deviceGroupRequestDto) {
        if (deviceGroupRequestDto == null) throw new MapperException("DeviceGroupRequestDto is null");
        return DeviceGroup.builder()
                .name(deviceGroupRequestDto.name())
                .description(deviceGroupRequestDto.description())
                .available(deviceGroupRequestDto.available())
                .build();
    }

    public static DeviceGroupResponseDto toDeviceGroupResponseDto(DeviceGroup deviceGroup) {
        if (deviceGroup == null) throw new MapperException("DeviceGroup is null");
        return DeviceGroupResponseDto.builder()
                .id(deviceGroup.getId())
                .name(deviceGroup.getName())
                .description(deviceGroup.getDescription())
                .available(deviceGroup.isAvailable())
                .build();
    }

    public static DeviceGroup toDeviceGroup(long id, DeviceGroupRequestDto deviceGroupRequestDto) {
        if (deviceGroupRequestDto == null) throw new MapperException("DeviceGroupRequestDto is null");
        return DeviceGroup.builder()
                .id(id)
                .name(deviceGroupRequestDto.name())
                .description(deviceGroupRequestDto.description())
                .available(deviceGroupRequestDto.available())
                .build();
    }

    public static Page<DeviceGroupResponseDto> toDeviceGroupResponseDtoPage(Page<DeviceGroup> deviceGroups) {
        if (deviceGroups == null) throw new MapperException("Page<DeviceGroup> is null");
        return deviceGroups.map(DeviceGroupMapper::toDeviceGroupResponseDto);
    }
}
