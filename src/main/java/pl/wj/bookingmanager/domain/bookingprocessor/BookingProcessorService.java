package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.BookingRepository;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.BookingMapper;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedDeviceDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedRoomDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingProcessorService {
    private final BookingRepository bookingRepository;
    private final SecurityService securityService;
    private final Clock clock;

    public BookingResponseDto addBooking(BookingRequestDto bookingRequestDto) {
        User createdByUser = securityService.getAuthenticatedUser();
        Booking booking = BookingMapper.toBooking(createdByUser.getId(), bookingRequestDto);
        booking = bookingRepository.save(booking);
        return BookingMapper.toBookingResponseDto(booking);
    }

    public BookingResponseDto updateBooking(long id, BookingRequestDto bookingRequestDto) {
        Booking booking = bookingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Booking with id " + id + " does not exist"));
        User updatedByUser = securityService.getAuthenticatedUser();
        booking = BookingMapper.toBooking(updatedByUser.getId(), booking, bookingRequestDto);
        booking = bookingRepository.save(booking);
        return BookingMapper.toBookingResponseDto(booking);
    }

    public void deleteBooking(long id) {
        if(!bookingRepository.existsById(id)) throw new ResourceNotFoundException("Booking with id " + id + " does not exist");
        bookingRepository.deleteById(id);
    }

    public BookingResponseDto getBooking(long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Booking with id " + id + " does not exist"));
        return BookingMapper.toBookingResponseDto(booking);
    }

    public Page<BookingResponseDto> getAllBookings(Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findAll(pageable);
        return BookingMapper.toBookingResponseDtoPage(bookings);
    }

    public Page<BookingResponseDto> getActiveBookings(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now(clock);
        Page<Booking> bookings = bookingRepository.findAllActive(pageable, now);
        return BookingMapper.toBookingResponseDtoPage(bookings);
    }

    public Page<BookingResponseDto> getFutureBookings(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now(clock);
        Page<Booking> bookings = bookingRepository.findAllFuture(pageable, now);
        return BookingMapper.toBookingResponseDtoPage(bookings);
    }

    public Page<BookingResponseDto> getExpiredBookings(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now(clock);
        Page<Booking> bookings = bookingRepository.findAllExpired(pageable, now);
        return BookingMapper.toBookingResponseDtoPage(bookings);
    }

    public Set<BookedDeviceDto> getBookedDevices(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + bookingId + " does not exist"));
        return BookingMapper.toBookedDeviceDtos(booking.getDevices());
    }

    public BookedRoomDto getBookedRoom(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with id " + bookingId + " does not exist"));
        return BookingMapper.toBookedRoomDto(booking.getRoom());
    }
}
