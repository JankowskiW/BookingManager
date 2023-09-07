package pl.wj.bookingmanager.domain.devicegroupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.DeviceGroup;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.DeviceGroupMapper;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.dto.DeviceGroupRequestDto;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.dto.DeviceGroupResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.ExceptionMessage;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceGroupProcessorService {
    private final DeviceGroupRepository deviceGroupRepository;

    public DeviceGroupResponseDto addDeviceGroup(DeviceGroupRequestDto deviceGroupRequestDto) {
        DeviceGroup deviceGroup = DeviceGroupMapper.toDeviceGroup(deviceGroupRequestDto);
        deviceGroup = deviceGroupRepository.save(deviceGroup);
        return DeviceGroupMapper.toDeviceGroupResponseDto(deviceGroup);
    }

    public DeviceGroupResponseDto updateDeviceGroup(long id, DeviceGroupRequestDto deviceGroupRequestDto) {
        if (!deviceGroupRepository.existsById(id))
            throw new ResourceNotFoundException(ExceptionMessage.getResourceNotFoundMessage("DeviceGroup", id));
        DeviceGroup deviceGroup = DeviceGroupMapper.toDeviceGroup(id, deviceGroupRequestDto);
        deviceGroup = deviceGroupRepository.save(deviceGroup);
        return DeviceGroupMapper.toDeviceGroupResponseDto(deviceGroup);
    }

    public Page<DeviceGroupResponseDto> getDeviceGroups(AvailabilityStatus availabilityStatus, Pageable pageable) {
        Page<DeviceGroup> deviceGroups = new PageImpl<>(List.of());
        switch (availabilityStatus) {
            case ALL -> deviceGroups = deviceGroupRepository.findAll(pageable);
            case AVAILABLE, UNAVAILABLE ->
                deviceGroups = deviceGroupRepository.findAllByAvailable(availabilityStatus.getAvailable(), pageable);
        }
        return DeviceGroupMapper.toDeviceGroupResponseDtoPage(deviceGroups);
    }
}
