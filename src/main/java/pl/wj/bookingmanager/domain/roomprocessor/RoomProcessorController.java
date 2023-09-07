package pl.wj.bookingmanager.domain.roomprocessor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomRequestDto;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomProcessorController {
    private final RoomProcessorService roomProcessorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomResponseDto addRoom(@RequestBody @Valid RoomRequestDto roomRequestDto) {
        return roomProcessorService.addRoom(roomRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponseDto updateRoom(@PathVariable long id, @RequestBody @Valid RoomRequestDto roomRequestDto) {
        return roomProcessorService.updateRoom(id, roomRequestDto);
    }

    @GetMapping("/{id}")
    public RoomResponseDto getRoom(@PathVariable long id) {
        return roomProcessorService.getRoom(id);
    }

    @GetMapping
    public Page<RoomResponseDto> getRooms(@RequestParam AvailabilityStatus availabilityStatus,
                                              @RequestParam(required = false) Integer pageNumber,
                                              @RequestParam(required = false) Integer pageSize,
                                              @RequestParam(required = false) Sort.Direction direction,
                                              @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return roomProcessorService.getRooms(availabilityStatus, pageable);
    }
}
