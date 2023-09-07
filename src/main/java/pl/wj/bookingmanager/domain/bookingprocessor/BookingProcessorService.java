package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.common.enumerator.BookingStatus;
import pl.wj.bookingmanager.common.enumerator.CommentObjectType;
import pl.wj.bookingmanager.domain.bookingprocessor.model.Booking;
import pl.wj.bookingmanager.domain.bookingprocessor.model.BookingMapper;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookedDeviceDto;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookedRoomDto;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.commentprocessor.CommentProcessorService;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingProcessorService {
    private final BookingRepository bookingRepository;
    private final CommentProcessorService commentProcessorService;
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

    public Page<BookingResponseDto> getBookings(BookingStatus bookingStatus, Pageable pageable) {
        Page<Booking> bookings = new PageImpl<>(List.of());
        switch (bookingStatus) {
            case ALL -> bookings = bookingRepository.findAll(pageable);
            case ACTIVE -> bookings = bookingRepository.findAllActive(pageable, LocalDateTime.now(clock));
            case EXPIRED -> bookings = bookingRepository.findAllExpired(pageable, LocalDateTime.now(clock));
            case FUTURE -> bookings = bookingRepository.findAllFuture(pageable, LocalDateTime.now(clock));
        }
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

    public CommentResponseDto addComment(long id, CommentRequestDto commentRequestDto) {
        if(!bookingRepository.existsById(id))
            throw new ResourceNotFoundException("Booking with id " + id + " does not exist");
        User createdByUser = securityService.getAuthenticatedUser();
        return commentProcessorService.addComment(
                id, createdByUser.getId(), CommentObjectType.BOOKING, commentRequestDto);
    }

    public Set<CommentResponseDto> getComments(long bookingId) {
        if(!bookingRepository.existsById(bookingId))
            throw new ResourceNotFoundException("Booking with id " + bookingId + " does not exist");
        return commentProcessorService.getCommentsByObjectIdAndObjectType(bookingId, CommentObjectType.BOOKING);
    }
}
