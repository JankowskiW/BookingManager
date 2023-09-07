package pl.wj.bookingmanager.domain.devicegroupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.dto.DeviceGroupRequestDto;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.dto.DeviceGroupResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device-groups")
public class DeviceGroupProcessorController {
    private final DeviceGroupProcessorService deviceGroupProcessorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceGroupResponseDto addDeviceGroup(@RequestBody DeviceGroupRequestDto deviceGroupRequestDto) {
        return deviceGroupProcessorService.addDeviceGroup(deviceGroupRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceGroupResponseDto updateDeviceGroup(@PathVariable long id, @RequestBody DeviceGroupRequestDto deviceGroupRequestDto) {
        return deviceGroupProcessorService.updateDeviceGroup(id, deviceGroupRequestDto);
    }

    @GetMapping
    public Page<DeviceGroupResponseDto> getDeviceGroups(@RequestParam AvailabilityStatus availabilityStatus,
                                                        @RequestParam(required = false) Integer pageNumber,
                                                        @RequestParam(required = false) Integer pageSize,
                                                        @RequestParam(required = false) Sort.Direction direction,
                                                        @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return deviceGroupProcessorService.getDeviceGroups(availabilityStatus, pageable);
    }
}
