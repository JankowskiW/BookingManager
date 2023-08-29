package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingProcessorController {
    private final BookingProcessorService bookingProcessorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDto addBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingProcessorService.addBooking(bookingRequestDto);
    }
}
