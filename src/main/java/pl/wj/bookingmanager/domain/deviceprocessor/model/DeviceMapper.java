package pl.wj.bookingmanager.domain.deviceprocessor.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceRequestDto;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.ExceptionMessage;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

public class DeviceMapper {
    public static Device toDevice(DeviceRequestDto deviceRequestDto) {
        if (deviceRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "DeviceRequestDto"));
        return Device.builder()
                .name(deviceRequestDto.name())
                .description(deviceRequestDto.description())
                .available(deviceRequestDto.available())
                .build();
    }

    public static Device toDevice(Device device, DeviceRequestDto deviceRequestDto) {
        if (device == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Device"));
        if (deviceRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "DeviceRequestDto"));
        device.setName(device.getName());
        device.setDescription(device.getDescription());
        device.setAvailable(deviceRequestDto.available());
        return device;
    }

    public static DeviceResponseDto toDeviceResponseDto(Device device) {
        if (device == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Device"));
        return DeviceResponseDto.builder()
                .id(device.getId())
                .name(device.getName())
                .description(device.getDescription())
                .available(device.isAvailable())
                .build();
    }

    public static Page<DeviceResponseDto> toDeviceResponseDtoPage(Page<Device> devices) {
        if (devices == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Page<Device>"));
        return devices.map(DeviceMapper::toDeviceResponseDto);
    }
}
