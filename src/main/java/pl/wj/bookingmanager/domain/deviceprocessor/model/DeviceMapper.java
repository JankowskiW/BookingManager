package pl.wj.bookingmanager.domain.deviceprocessor.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceRequestDto;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

public class DeviceMapper {
    public static Device toDevice(DeviceRequestDto deviceRequestDto) {
        if (deviceRequestDto == null) throw new MapperException("DeviceRequestDto is null");
        return Device.builder()
                .name(deviceRequestDto.name())
                .description(deviceRequestDto.description())
                .available(deviceRequestDto.available())
                .build();
    }

    public static Device toDevice(long id, DeviceRequestDto deviceRequestDto) {
        if (deviceRequestDto == null) throw new MapperException("DeviceRequestDto is null");
        return Device.builder()
                .id(id)
                .name(deviceRequestDto.name())
                .description(deviceRequestDto.description())
                .available(deviceRequestDto.available())
                .build();
    }

    public static DeviceResponseDto toDeviceResponseDto(Device device) {
        if (device == null) throw new MapperException("Device is null");
        return DeviceResponseDto.builder()
                .id(device.getId())
                .name(device.getName())
                .description(device.getDescription())
                .available(device.isAvailable())
                .build();
    }

    public static Page<DeviceResponseDto> toDeviceResponseDtoPage(Page<Device> devices) {
        return devices.map(DeviceMapper::toDeviceResponseDto);
    }
}
