package pl.wj.bookingmanager.domain.roomprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.BookingRepository;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class RoomProcessorService {
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public void throwIfNotExistsById(long id) {
        if(!roomRepository.existsById(id))
            throw new ResourceNotFoundException("Room with id " + id + " does not exist");
    }


//    public Set<RoomsBookingResponseDto> getRoomWithBookingsByRoomId(long id) {
//        Room room = roomRepository.findByIdWithBookings(id).orElseThrow(
//                () -> new ResourceNotFoundException("Room with id " + id + " does not exist"));
//        Set<Booking> bookings = room.getBookings();
//        bookings.forEach(b -> System.out.println(b.getId()));
//        return Set.of();
////        return RoomMapper.toRoomsBookingsResponseDtos(room.getBookings());
//    }
}
