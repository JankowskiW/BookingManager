package pl.wj.bookingmanager.domain.roomprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomProcessorController {
    private final RoomProcessorService roomProcessorService;

//    @GetMapping("/{id}/bookings")
//    public Set<RoomsBookingResponseDto> getBookingsForRoom(@PathVariable long id) {
//        return roomProcessorService.getRoomWithBookingsByRoomId(id);
//    }
}
