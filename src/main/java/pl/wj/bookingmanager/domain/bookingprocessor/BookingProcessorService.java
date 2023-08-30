package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.BookingRepository;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.BookingMapper;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.deviceprocessor.DeviceProcessorService;
import pl.wj.bookingmanager.domain.roomprocessor.RoomProcessorService;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingProcessorService {
    private final BookingRepository bookingRepository;
    private final DeviceProcessorService deviceProcessorService;
    private final RoomProcessorService roomProcessorService;
    private final SecurityService securityService;
    private final Clock clock;

    public BookingResponseDto addBooking(BookingRequestDto bookingRequestDto) {
        System.out.println("B");
        if (bookingRequestDto.roomId().isPresent())
            roomProcessorService.throwIfNotExistsById(bookingRequestDto.roomId().get());
        System.out.println("C");
        if (bookingRequestDto.devicesIds().isPresent() && !bookingRequestDto.devicesIds().get().isEmpty())
            deviceProcessorService.throwIfNotExistsById(bookingRequestDto.devicesIds().get());
        System.out.println("D");
        User createdByUser = securityService.getAuthenticatedUser();
        System.out.println("E");
        Booking booking = BookingMapper.toBooking(createdByUser, bookingRequestDto);
        System.out.println("F");
        booking = bookingRepository.save(booking);
        return BookingMapper.toBookingResponseDto(booking);
    }

    public BookingResponseDto updateBooking(long id, BookingRequestDto bookingRequestDto) {
        throwIfNotExistsById(id);
        if (bookingRequestDto.roomId().isPresent())
            roomProcessorService.throwIfNotExistsById(bookingRequestDto.roomId().get());
        if (bookingRequestDto.devicesIds().isPresent() && !bookingRequestDto.devicesIds().get().isEmpty())
            deviceProcessorService.throwIfNotExistsById(bookingRequestDto.devicesIds().get());
        User createdByUser = securityService.getAuthenticatedUser();
        Booking booking = BookingMapper.toBooking(id, createdByUser, bookingRequestDto);
        booking = bookingRepository.save(booking);
        return BookingMapper.toBookingResponseDto(booking);
    }

    public void deleteBooking(long id) {
        bookingRepository.deleteById(id);
    }

    public BookingResponseDto getBooking(long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Booking with id " + id + " does not exist"));
        return BookingMapper.toBookingResponseDto(booking);
    }

    public Page<BookingResponseDto> getBookings(Pageable pageable) {
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

    public Page<BookingResponseDto> getBookingsByRoomId(Pageable pageable, long roomId) {
        Page<Booking> bookings = bookingRepository.findAllByRoomId(pageable, roomId);
        return BookingMapper.toBookingResponseDtoPage(bookings);
    }

//    public Page<BookingResponseDto> getBookingsByDeviceId(Pageable pageable, long deviceId) {
//        Page<Booking> bookings = bookingRepository.findAllByDevices(pageable, Device.createWithId(deviceId));
//        return BookingMapper.toBookingResponseDtoPage(bookings);
//    }

    public Page<BookingResponseDto> getBookingsByUserId(Pageable pageable, long userId) {
        Page<Booking> bookings = bookingRepository.findAllByCreatedByUser(pageable, User.createWithId(userId));
        return BookingMapper.toBookingResponseDtoPage(bookings);
    }

    public void throwIfNotExistsById(long id) {
        if(!bookingRepository.existsById(id))
            throw new ResourceNotFoundException("Booking with id " + id + " does not exist");
    }
}
