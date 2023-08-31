package pl.wj.bookingmanager.domain.groupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupUpdateRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupUpdateRequestDto;

@RestController
@RequiredArgsConstructor
public class GroupProcessorController {
    private final GroupProcessorService groupProcessorService;

//    DEVICE GROUPS
    @PostMapping("/device-groups")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceGroupResponseDto addDeviceGroup(@RequestBody DeviceGroupRequestDto deviceGroupRequestDto) {
        return groupProcessorService.addDeviceGroup(deviceGroupRequestDto);
    }

    @PutMapping("/device-groups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceGroupResponseDto updateDeviceGroup(@PathVariable long id, @RequestBody DeviceGroupUpdateRequestDto deviceGroupUpdateRequestDto) {
        return groupProcessorService.updateDeviceGroup(id, deviceGroupUpdateRequestDto);
    }

    @GetMapping("/device-groups")
    public Page<DeviceGroupResponseDto> getDeviceGroups(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                        @RequestParam Sort.Direction direction, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return groupProcessorService.getDeviceGroups(pageable);
    }

    @GetMapping("/device-groups/available")
    public Page<DeviceGroupResponseDto> getAvailableDeviceGroups(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                                 @RequestParam Sort.Direction direction, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return groupProcessorService.getAvailableDeviceGroups(pageable);
    }

    @GetMapping("/device-groups/unavailable")
    public Page<DeviceGroupResponseDto> getUnavailableDeviceGroups(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                                 @RequestParam Sort.Direction direction, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return groupProcessorService.getUnavailableDeviceGroups(pageable);
    }

//    ROOM GROUPS
    @PostMapping("/room-groups")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomGroupResponseDto addRoomGroup(@RequestBody RoomGroupRequestDto roomGroupRequestDto) {
        return groupProcessorService.addRoomGroup(roomGroupRequestDto);
    }

    @PutMapping("/room-groups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomGroupResponseDto updateRoomGroup(@PathVariable long id, @RequestBody RoomGroupUpdateRequestDto roomGroupUpdateRequestDto) {
        return groupProcessorService.updateRoomGroup(id, roomGroupUpdateRequestDto);
    }

    @GetMapping("/room-groups")
    public Page<RoomGroupResponseDto> getRoomGroups(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                        @RequestParam Sort.Direction direction, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return groupProcessorService.getRoomGroups(pageable);
    }

    @GetMapping("/room-groups/available")
    public Page<RoomGroupResponseDto> getAvailableRoomGroups(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                                 @RequestParam Sort.Direction direction, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return groupProcessorService.getAvailableRoomGroups(pageable);
    }

    @GetMapping("/room-groups/unavailable")
    public Page<RoomGroupResponseDto> getUnavailableRoomGroups(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                                   @RequestParam Sort.Direction direction, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, sortBy);
        return groupProcessorService.getUnavailableRoomGroups(pageable);
    }
}
