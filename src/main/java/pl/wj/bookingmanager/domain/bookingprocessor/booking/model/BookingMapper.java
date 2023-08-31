package pl.wj.bookingmanager.domain.bookingprocessor.booking.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedDeviceDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookedRoomDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class BookingMapper {

    public static Booking toBooking(long createdBy, BookingRequestDto bookingRequestDto) {
        return Booking.builder()
                .title(bookingRequestDto.title())
                .description(bookingRequestDto.description())
                .validFrom(bookingRequestDto.validFrom())
                .validTo(bookingRequestDto.validTo())
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }

    public static Booking toBooking(long updatedBy, Booking booking, BookingRequestDto bookingRequestDto) {
        return Booking.builder()
                .id(booking.getId())
                .title(bookingRequestDto.title())
                .description(bookingRequestDto.description())
                .validFrom(bookingRequestDto.validFrom())
                .validTo(bookingRequestDto.validTo())
                .createdBy(booking.getCreatedBy())
                .updatedBy(updatedBy)
                .createdAt(booking.getCreatedAt())
                .devices(booking.getDevices()) // Added to avoid deleting relations after Booking update
                .build();
    }

    public static BookingResponseDto toBookingResponseDto(Booking booking) {
        return BookingResponseDto.builder()
                .id(booking.getId())
                .title(booking.getTitle())
                .description(booking.getDescription())
                .validFrom(booking.getValidFrom())
                .validTo(booking.getValidTo())
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
