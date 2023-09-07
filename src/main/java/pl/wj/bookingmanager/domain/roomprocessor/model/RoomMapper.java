package pl.wj.bookingmanager.domain.roomprocessor.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomRequestDto;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

public class RoomMapper {
    public static Room toRoom(RoomRequestDto roomRequestDto) {
        if (roomRequestDto == null) throw new MapperException("RoomRequestDto is null");
        return Room.builder()
                .name(roomRequestDto.name())
                .description(roomRequestDto.description())
                .location(roomRequestDto.location())
                .available(roomRequestDto.available())
                .build();
    }

    public static RoomResponseDto toRoomResponseDto(Room room) {
        if (room == null) throw new MapperException("Room is null");
        return RoomResponseDto.builder()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .location(room.getLocation())
                .available(room.isAvailable())
                .build();
    }

    public static Room toRoom(Room room, RoomRequestDto roomRequestDto) {
        if (roomRequestDto == null) throw new MapperException("RoomRequestDto is null");
        room.setName(roomRequestDto.name());
        room.setDescription(roomRequestDto.description());
        room.setLocation(roomRequestDto.location());
        room.setAvailable(roomRequestDto.available());
        return room;
    }

    public static Page<RoomResponseDto> toRoomResponseDtoPage(Page<Room> rooms) {
        return rooms.map(RoomMapper::toRoomResponseDto);
    }
}
