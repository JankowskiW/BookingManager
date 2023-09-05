package pl.wj.bookingmanager.domain.groupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.dto.DeviceGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupRequestDto;

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
    public DeviceGroupResponseDto updateDeviceGroup(@PathVariable long id, @RequestBody DeviceGroupRequestDto deviceGroupRequestDto) {
        return groupProcessorService.updateDeviceGroup(id, deviceGroupRequestDto);
    }

    @GetMapping("/device-groups")
    public Page<DeviceGroupResponseDto> getDeviceGroups(@RequestParam(required = false) Integer pageNumber,
                                                        @RequestParam(required = false) Integer pageSize,
                                                        @RequestParam(required = false) Sort.Direction direction,
                                                        @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return groupProcessorService.getDeviceGroups(pageable);
    }

    @GetMapping("/device-groups/available")
    public Page<DeviceGroupResponseDto> getAvailableDeviceGroups(@RequestParam(required = false) Integer pageNumber,
                                                                 @RequestParam(required = false) Integer pageSize,
                                                                 @RequestParam(required = false) Sort.Direction direction,
                                                                 @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return groupProcessorService.getAvailableDeviceGroups(pageable);
    }

    @GetMapping("/device-groups/unavailable")
    public Page<DeviceGroupResponseDto> getUnavailableDeviceGroups(@RequestParam(required = false) Integer pageNumber,
                                                                   @RequestParam(required = false) Integer pageSize,
                                                                   @RequestParam(required = false) Sort.Direction direction,
                                                                   @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
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
    public RoomGroupResponseDto updateRoomGroup(@PathVariable long id, @RequestBody RoomGroupRequestDto roomGroupRequestDto) {
        return groupProcessorService.updateRoomGroup(id, roomGroupRequestDto);
    }

    @GetMapping("/room-groups")
    public Page<RoomGroupResponseDto> getRoomGroups(@RequestParam(required = false) Integer pageNumber,
                                                    @RequestParam(required = false) Integer pageSize,
                                                    @RequestParam(required = false) Sort.Direction direction,
                                                    @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return groupProcessorService.getRoomGroups(pageable);
    }

    @GetMapping("/room-groups/available")
    public Page<RoomGroupResponseDto> getAvailableRoomGroups(@RequestParam(required = false) Integer pageNumber,
                                                             @RequestParam(required = false) Integer pageSize,
                                                             @RequestParam(required = false) Sort.Direction direction,
                                                             @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return groupProcessorService.getAvailableRoomGroups(pageable);
    }

    @GetMapping("/room-groups/unavailable")
    public Page<RoomGroupResponseDto> getUnavailableRoomGroups(@RequestParam(required = false) Integer pageNumber,
                                                               @RequestParam(required = false) Integer pageSize,
                                                               @RequestParam(required = false) Sort.Direction direction,
                                                               @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return groupProcessorService.getUnavailableRoomGroups(pageable);
    }
}
