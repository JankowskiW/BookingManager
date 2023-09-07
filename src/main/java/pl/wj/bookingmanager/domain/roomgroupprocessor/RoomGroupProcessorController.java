package pl.wj.bookingmanager.domain.roomgroupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto.RoomGroupResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room-groups")
public class RoomGroupProcessorController {
    private final RoomGroupProcessorService roomGroupProcessorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomGroupResponseDto addRoomGroup(@RequestBody RoomGroupRequestDto roomGroupRequestDto) {
        return roomGroupProcessorService.addRoomGroup(roomGroupRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomGroupResponseDto updateRoomGroup(@PathVariable long id, @RequestBody RoomGroupRequestDto roomGroupRequestDto) {
        return roomGroupProcessorService.updateRoomGroup(id, roomGroupRequestDto);
    }

    @GetMapping
    public Page<RoomGroupResponseDto> getRoomGroups(@RequestParam AvailabilityStatus availabilityStatus,
                                                    @RequestParam(required = false) Integer pageNumber,
                                                    @RequestParam(required = false) Integer pageSize,
                                                    @RequestParam(required = false) Sort.Direction direction,
                                                    @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return roomGroupProcessorService.getRoomGroups(availabilityStatus, pageable);
    }
}
