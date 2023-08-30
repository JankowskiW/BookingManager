package pl.wj.bookingmanager.domain.bookingprocessor.booking.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingRequestDto;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto.BookingResponseDto;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingMapper {

    public static Booking toBooking(long id, User updatedByUser, BookingRequestDto bookingRequestDto) {
        return toBooking(updatedByUser, bookingRequestDto).withId(id);
    }

    public static Booking toBooking(User createdByUser, BookingRequestDto bookingRequestDto) {
        return Booking.builder()
                .title(bookingRequestDto.title())
                .description(bookingRequestDto.description())
                .validFrom(bookingRequestDto.validFrom())
                .validTo(bookingRequestDto.validTo())
                .room(createRoomIfAnyBooked(bookingRequestDto.roomId()))
                .devices(createDevicesIfAnyBooked(bookingRequestDto.devicesIds()))
                .createdByUser(createdByUser)
                .updatedByUser(createdByUser)
                .build();
    }

    private static Set<Device> createDevicesIfAnyBooked(Optional<Set<Long>> devicesIds) {
        if (devicesIds.isEmpty()) return new HashSet<>();
        return devicesIds.get().stream().map(id -> Device.builder().id(id).build()).collect(Collectors.toSet());
    }

    private static Room createRoomIfAnyBooked(Optional<Long> id) {
        if (id.isEmpty()) return null;
        return Room.builder()
                .id(id.get())
                .build();
    }

    public static BookingResponseDto toBookingResponseDto(Booking booking) {
        BookingResponseDto.BookingResponseDtoBuilder builder = BookingResponseDto.builder()
                .id(booking.getId())
                .title(booking.getTitle())
                .description(booking.getDescription())
                .validFrom(booking.getValidFrom())
                .validTo(booking.getValidTo())
                .createdAt(booking.getCreatedAt())
                .updatedAt(booking.getUpdatedAt())
                .createdBy(booking.getCreatedByUser().getId())
                .updatedBy(booking.getUpdatedByUser().getId());
        if (booking.getRoom() != null) builder.roomId(Optional.of(booking.getRoom().getId()));
        if (booking.getDevices() != null)
            builder.devicesIds(Optional.of(booking.getDevices().stream().map(Device::getId).collect(Collectors.toSet())));
        return builder.build();
    }

    public static Page<BookingResponseDto> toBookingResponseDtoPage(Page<Booking> bookings) {
        return bookings.map(BookingMapper::toBookingResponseDto);
    }
}
