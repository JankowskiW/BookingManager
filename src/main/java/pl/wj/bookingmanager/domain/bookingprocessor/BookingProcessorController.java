package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;

@RestController
@RequiredArgsConstructor
public class BookingProcessorController {
    private final BookingProcessorService bookingProcessorService;

    @PostMapping("/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDto addBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        System.out.println("A");
        return bookingProcessorService.addBooking(bookingRequestDto);
    }

    @PutMapping("/bookings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookingResponseDto updateBooking(@PathVariable long id, @RequestBody BookingRequestDto bookingRequestDto) {
        return bookingProcessorService.updateBooking(id, bookingRequestDto);
    }

    @DeleteMapping("/bookings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable long id) {
        bookingProcessorService.deleteBooking(id);
    }

    @GetMapping("/bookings/{id}")
    public BookingResponseDto getBooking(@PathVariable long id) {
        return bookingProcessorService.getBooking(id);
    }

    @GetMapping("/bookings")
    public Page<BookingResponseDto> getBookings(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                @RequestParam Sort.Direction direction, @RequestParam String directionField) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
        return bookingProcessorService.getBookings(pageable);
    }

    @GetMapping("/bookings/active")
    public Page<BookingResponseDto> getActiveBookings(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                @RequestParam Sort.Direction direction, @RequestParam String directionField) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
        return bookingProcessorService.getActiveBookings(pageable);
    }

    @GetMapping("/bookings/future")
    public Page<BookingResponseDto> getFutureBookings(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                      @RequestParam Sort.Direction direction, @RequestParam String directionField) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
        return bookingProcessorService.getFutureBookings(pageable);
    }

    @GetMapping("/bookings/expired")
    public Page<BookingResponseDto> getExpiredBookings(@RequestParam int pageNumber, @RequestParam int pageSize,
                                                        @RequestParam Sort.Direction direction, @RequestParam String directionField) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
        return bookingProcessorService.getExpiredBookings(pageable);
    }

    @GetMapping("/rooms/{roomId}/bookings")
    public Page<BookingResponseDto> getBookingsForRoom(@PathVariable long roomId, @RequestParam int pageNumber, @RequestParam int pageSize,
                                                      @RequestParam Sort.Direction direction, @RequestParam String directionField) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
        return bookingProcessorService.getBookingsByRoomId(pageable, roomId);
    }

//    @GetMapping("/devices/{deviceId}/bookings")
//    public Page<BookingResponseDto> getBookingsForDevice(@PathVariable long deviceId, @RequestParam int pageNumber, @RequestParam int pageSize,
//                                                        @RequestParam Sort.Direction direction, @RequestParam String directionField) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
//        return bookingProcessorService.getBookingsByDeviceId(pageable, deviceId);
//    }

    @GetMapping("/users/{userId}/bookings")
    public Page<BookingResponseDto> getBookingsForUser(@PathVariable long userId, @RequestParam int pageNumber, @RequestParam int pageSize,
                                                        @RequestParam Sort.Direction direction, @RequestParam String directionField) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, direction, directionField);
        return bookingProcessorService.getBookingsByUserId(pageable, userId);
    }
}
