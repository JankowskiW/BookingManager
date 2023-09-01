package pl.wj.bookingmanager.domain.bookingprocessor.booking.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.bookingprocessor.BookingValidator;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedDeviceDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedRoomDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingMapper {
    // TODO: Change every mapper methods to non static method and avery Mapper to @Component and inject Clock field and Validators

    public static Booking toBooking(long createdBy, BookingRequestDto bookingRequestDto) {
        validateStartTimeAndEndTime(bookingRequestDto.startTime(), bookingRequestDto.endTime());
        return Booking.builder()
                .title(bookingRequestDto.title())
                .description(bookingRequestDto.description())
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .startTime(bookingRequestDto.startTime())
                .endTime(bookingRequestDto.endTime())
                .build();
    }

    public static Booking toBooking(long updatedBy, Booking booking, BookingRequestDto bookingRequestDto) {
        validateStartTimeAndEndTime(bookingRequestDto.startTime(), bookingRequestDto.endTime());
        booking.setTitle(bookingRequestDto.title());
        booking.setDescription(bookingRequestDto.description());
        booking.setUpdatedBy(updatedBy);
        booking.setStartTime(bookingRequestDto.startTime());
        booking.setEndTime(booking.getEndTime());
        return booking;
    }

    private static void validateStartTimeAndEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        BookingValidator.hasInvalidDurationTime(startTime, endTime);
        BookingValidator.isBeforeCurrentDateTime(startTime);
        BookingValidator.isBeforeCurrentDateTime(endTime);
    }

    public static BookingResponseDto toBookingResponseDto(Booking booking) {
        return BookingResponseDto.builder()
                .id(booking.getId())
                .title(booking.getTitle())
                .description(booking.getDescription())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .createdAt(booking.getCreatedAt())
                .updatedAt(booking.getUpdatedAt())
                .createdBy(booking.getCreatedBy())
                .updatedBy(booking.getUpdatedBy())
                .build();
    }

    public static Page<BookingResponseDto> toBookingResponseDtoPage(Page<Booking> bookings) {
        return bookings.map(BookingMapper::toBookingResponseDto);
    }

    public static Set<BookedDeviceDto> toBookedDeviceDtos(Set<Device> devices) {
        return devices.stream().map(BookingMapper::toBookedDeviceDto).collect(Collectors.toSet());
    }

    public static BookedDeviceDto toBookedDeviceDto(Device device) {
        return BookedDeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .description(device.getDescription())
                .available(device.isAvailable())
                .build();
    }

    public static BookedRoomDto toBookedRoomDto(Room room) {
        return BookedRoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .location(room.getLocation())
                .available(room.isAvailable())
                .build();
    }
}
