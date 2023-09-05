package pl.wj.bookingmanager.domain.deviceprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.deviceprocessor.model.Device;
import pl.wj.bookingmanager.domain.deviceprocessor.model.DeviceMapper;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceRequestDto;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class DeviceProcessorService {
    private final DeviceRepository deviceRepository;

    public DeviceResponseDto addDevice(DeviceRequestDto deviceRequestDto) {
        Device device = DeviceMapper.toDevice(deviceRequestDto);
        device = deviceRepository.save(device);
        return DeviceMapper.toDeviceResponseDto(device);
    }

    public DeviceResponseDto updateDevice(long id, DeviceRequestDto deviceRequestDto) {
        Device device = deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Device with id " + id + " does not exist"));
        device = DeviceMapper.toDevice(device, deviceRequestDto);
        device = deviceRepository.save(device);
        return DeviceMapper.toDeviceResponseDto(device);
    }

    public DeviceResponseDto getDevice(long id) {
        Device device = deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Device with id " + id + " does not exist"));
        return DeviceMapper.toDeviceResponseDto(device);
    }

    public Page<DeviceResponseDto> getAllDevices(Pageable pageable) {
        Page<Device> devices = deviceRepository.findAll(pageable);
        return DeviceMapper.toDeviceResponseDtoPage(devices);
    }

    public Page<DeviceResponseDto> getAvailableDevices(Pageable pageable) {
        Page<Device> devices = deviceRepository.findAllByAvailable(true, pageable);
        return DeviceMapper.toDeviceResponseDtoPage(devices);
    }

    public Page<DeviceResponseDto> getUnavailableDevices(Pageable pageable) {
        Page<Device> devices = deviceRepository.findAllByAvailable(false, pageable);
        return DeviceMapper.toDeviceResponseDtoPage(devices);
    }
}
