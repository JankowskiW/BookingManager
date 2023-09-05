package pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupRequestDto;

public class DeviceGroupMapper {
    public static DeviceGroup toDeviceGroup(DeviceGroupRequestDto deviceGroupRequestDto) {
        return DeviceGroup.builder()
                .name(deviceGroupRequestDto.name())
                .description(deviceGroupRequestDto.description())
                .build();
    }

    public static DeviceGroupResponseDto toDeviceGroupResponseDto(DeviceGroup deviceGroup) {
        return DeviceGroupResponseDto.builder()
                .id(deviceGroup.getId())
                .name(deviceGroup.getName())
                .description(deviceGroup.getDescription())
                .build();
    }

    public static DeviceGroup toDeviceGroup(long id, DeviceGroupRequestDto deviceGroupRequestDto) {
        return DeviceGroup.builder()
                .id(id)
                .name(deviceGroupRequestDto.name())
                .description(deviceGroupRequestDto.description())
                .build();
    }

    public static Page<DeviceGroupResponseDto> toDeviceGroupResponseDtoPage(Page<DeviceGroup> deviceGroups) {
        return deviceGroups.map(DeviceGroupMapper::toDeviceGroupResponseDto);
    }
}
