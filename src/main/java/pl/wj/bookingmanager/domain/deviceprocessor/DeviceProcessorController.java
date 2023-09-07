package pl.wj.bookingmanager.domain.deviceprocessor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceRequestDto;
import pl.wj.bookingmanager.domain.deviceprocessor.model.dto.DeviceResponseDto;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceProcessorController {
    private final DeviceProcessorService deviceProcessorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceResponseDto addDevice(@RequestBody @Valid DeviceRequestDto deviceRequestDto) {
        return deviceProcessorService.addDevice(deviceRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceResponseDto updateDevice(@PathVariable long id, @RequestBody @Valid DeviceRequestDto deviceRequestDto) {
        return deviceProcessorService.updateDevice(id, deviceRequestDto);
    }

    @GetMapping("/{id}")
    public DeviceResponseDto getDevice(@PathVariable long id) {
        return deviceProcessorService.getDevice(id);
    }

    @GetMapping
    public Page<DeviceResponseDto> getDevices(@RequestParam AvailabilityStatus availabilityStatus,
                                              @RequestParam(required = false) Integer pageNumber,
                                              @RequestParam(required = false) Integer pageSize,
                                              @RequestParam(required = false) Sort.Direction direction,
                                              @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return deviceProcessorService.getDevices(availabilityStatus, pageable);
    }
}
