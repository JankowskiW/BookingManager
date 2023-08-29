package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.BookingRepository;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.BookingMapper;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;

@Service
@RequiredArgsConstructor
public class BookingProcessorService {
    private final BookingRepository bookingRepository;
    private final SecurityService securityService;

    public BookingResponseDto addBooking(BookingRequestDto bookingRequestDto) {
        User createdByUser = securityService.getAuthenticatedUser();
        Booking booking = BookingMapper.toBooking(createdByUser, bookingRequestDto);
        booking = bookingRepository.save(booking);
        return  BookingMapper.toBookingResponseDto(booking);
    }


}
