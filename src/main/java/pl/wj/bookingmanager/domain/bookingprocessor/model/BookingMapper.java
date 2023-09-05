package pl.wj.bookingmanager.domain.bookingprocessor.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookedDeviceDto;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookedRoomDto;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.deviceprocessor.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class BookingMapper {
    public static Booking toBooking(long createdBy, BookingRequestDto bookingRequestDto) {
        if (bookingRequestDto == null) return null;
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
        if (booking == null || bookingRequestDto == null) return null;
        booking.setTitle(bookingRequestDto.title());
        booking.setDescription(bookingRequestDto.description());
        booking.setUpdatedBy(updatedBy);
        booking.setStartTime(bookingRequestDto.startTime());
        booking.setEndTime(booking.getEndTime());
        return booking;
    }

    public static BookingResponseDto toBookingResponseDto(Booking booking) {
        if (booking == null) return null;
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
        if (bookings == null) return null;
        return bookings.map(BookingMapper::toBookingResponseDto);
    }

    public static Set<BookedDeviceDto> toBookedDeviceDtos(Set<Device> devices) {
        if (devices == null) return null;
        return devices.stream().map(BookingMapper::toBookedDeviceDto).collect(Collectors.toSet());
    }

    public static BookedDeviceDto toBookedDeviceDto(Device device) {
        if (device == null) return null;
        return BookedDeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .description(device.getDescription())
                .available(device.isAvailable())
                .build();
    }

    public static BookedRoomDto toBookedRoomDto(Room room) {
        if (room == null) return null;
        return BookedRoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .location(room.getLocation())
                .available(room.isAvailable())
                .build();
    }
}
