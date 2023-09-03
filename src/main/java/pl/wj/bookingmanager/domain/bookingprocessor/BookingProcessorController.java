package pl.wj.bookingmanager.domain.bookingprocessor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedDeviceDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedRoomDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingProcessorController {
    private final BookingProcessorService bookingProcessorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDto addBooking(@RequestBody @Valid BookingRequestDto bookingRequestDto) {
        return bookingProcessorService.addBooking(bookingRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookingResponseDto updateBooking(@PathVariable long id,
                                            @RequestBody BookingRequestDto bookingRequestDto) {
        return bookingProcessorService.updateBooking(id, bookingRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable long id) {
        bookingProcessorService.deleteBooking(id);
    }

    @GetMapping("/{id}")
    public BookingResponseDto getBooking(@PathVariable long id) {
        return bookingProcessorService.getBooking(id);
    }

    @GetMapping
    public Page<BookingResponseDto> getAllBookings(@RequestParam(required = false) Integer pageNumber,
                                                   @RequestParam(required = false) Integer pageSize,
                                                   @RequestParam(required = false) Sort.Direction direction,
                                                   @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return bookingProcessorService.getAllBookings(pageable);
    }

    @GetMapping("/active")
    public Page<BookingResponseDto> getActiveBookings(@RequestParam(required = false) Integer pageNumber,
                                                      @RequestParam(required = false) Integer pageSize,
                                                      @RequestParam(required = false) Sort.Direction direction,
                                                      @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return bookingProcessorService.getActiveBookings(pageable);
    }

    @GetMapping("/future")
    public Page<BookingResponseDto> getFutureBookings(@RequestParam(required = false) Integer pageNumber,
                                                      @RequestParam(required = false) Integer pageSize,
                                                      @RequestParam(required = false) Sort.Direction direction,
                                                      @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return bookingProcessorService.getFutureBookings(pageable);
    }

    @GetMapping("/expired")
    public Page<BookingResponseDto> getExpiredBookings(@RequestParam(required = false) Integer pageNumber,
                                                       @RequestParam(required = false) Integer pageSize,
                                                       @RequestParam(required = false) Sort.Direction direction,
                                                       @RequestParam(required = false) String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return bookingProcessorService.getExpiredBookings(pageable);
    }

    @GetMapping("/{id}/devices")
    public Set<BookedDeviceDto> getBookedDevices(@PathVariable long id) {
        return bookingProcessorService.getBookedDevices(id);
    }

    @GetMapping("/{id}/rooms")
    public BookedRoomDto getBookedRoom(@PathVariable long id) {
        return bookingProcessorService.getBookedRoom(id);
    }
}
