package pl.wj.bookingmanager.domain.groupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.DeviceGroupRepository;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.DeviceGroup;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.DeviceGroupMapper;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupUpdateRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.RoomGroupRepository;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.RoomGroup;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.RoomGroupMapper;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupUpdateRequestDto;

@Service
@RequiredArgsConstructor
public class GroupProcessorService {
    private final DeviceGroupRepository deviceGroupRepository;
    private final RoomGroupRepository roomGroupRepository;

//    DEVICE GROUPS
    public DeviceGroupResponseDto addDeviceGroup(DeviceGroupRequestDto deviceGroupRequestDto) {
        DeviceGroup deviceGroup = DeviceGroupMapper.toDeviceGroup(deviceGroupRequestDto);
        deviceGroup = deviceGroupRepository.save(deviceGroup);
        return DeviceGroupMapper.toDeviceGroupResponseDto(deviceGroup);
    }

    public DeviceGroupResponseDto updateDeviceGroup(long id, DeviceGroupUpdateRequestDto deviceGroupUpdateRequestDto) {
        DeviceGroup deviceGroup = DeviceGroupMapper.toDeviceGroup(id, deviceGroupUpdateRequestDto);
        deviceGroup = deviceGroupRepository.save(deviceGroup);
        return DeviceGroupMapper.toDeviceGroupResponseDto(deviceGroup);
    }

    public Page<DeviceGroupResponseDto> getDeviceGroups(Pageable pageable) {
        return DeviceGroupMapper.toDeviceGroupResponseDtoPage(deviceGroupRepository.findAll(pageable));
    }

    public Page<DeviceGroupResponseDto> getAvailableDeviceGroups(Pageable pageable) {
        return DeviceGroupMapper.toDeviceGroupResponseDtoPage(deviceGroupRepository.findAllByAvailable(true, pageable));
    }

    public Page<DeviceGroupResponseDto> getUnavailableDeviceGroups(Pageable pageable) {
        return DeviceGroupMapper.toDeviceGroupResponseDtoPage(deviceGroupRepository.findAllByAvailable(false, pageable));
    }

//    ROOM GROUPS
    public RoomGroupResponseDto addRoomGroup(RoomGroupRequestDto roomGroupRequestDto) {
        RoomGroup roomGroup = RoomGroupMapper.toRoomGroup(roomGroupRequestDto);
        roomGroup = roomGroupRepository.save(roomGroup);
        return RoomGroupMapper.toRoomGroupResponseDto(roomGroup);
    }

    public RoomGroupResponseDto updateRoomGroup(long id, RoomGroupUpdateRequestDto roomGroupUpdateRequestDto) {
        RoomGroup roomGroup = RoomGroupMapper.toRoomGroup(id, roomGroupUpdateRequestDto);
        roomGroup = roomGroupRepository.save(roomGroup);
        return RoomGroupMapper.toRoomGroupResponseDto(roomGroup);
    }

    public Page<RoomGroupResponseDto> getRoomGroups(Pageable pageable) {
        return RoomGroupMapper.toRoomGroupResponseDtoPage(roomGroupRepository.findAll(pageable));
    }

    public Page<RoomGroupResponseDto> getAvailableRoomGroups(Pageable pageable) {
        return RoomGroupMapper.toRoomGroupResponseDtoPage(roomGroupRepository.findAllByAvailable(true, pageable));
    }

    public Page<RoomGroupResponseDto> getUnavailableRoomGroups(Pageable pageable) {
        return RoomGroupMapper.toRoomGroupResponseDtoPage(roomGroupRepository.findAllByAvailable(false, pageable));
    }
}
