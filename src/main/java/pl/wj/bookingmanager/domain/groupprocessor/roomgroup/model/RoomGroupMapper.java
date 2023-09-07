package pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

public class RoomGroupMapper {
    public static RoomGroup toRoomGroup(RoomGroupRequestDto roomGroupRequestDto) {
        if (roomGroupRequestDto == null) throw new MapperException("RoomGroupRequestDto is null");
        return RoomGroup.builder()
                .name(roomGroupRequestDto.name())
                .description(roomGroupRequestDto.description())
                .available(roomGroupRequestDto.available())
                .build();
    }

    public static RoomGroupResponseDto toRoomGroupResponseDto(RoomGroup roomGroup) {
        if (roomGroup == null) throw new MapperException("RoomGroup is null");
        return RoomGroupResponseDto.builder()
                .id(roomGroup.getId())
                .name(roomGroup.getName())
                .description(roomGroup.getDescription())
                .available(roomGroup.isAvailable())
                .build();
    }

    public static RoomGroup toRoomGroup(long id, RoomGroupRequestDto roomGroupRequestDto) {
        if (roomGroupRequestDto == null) throw new MapperException("RoomGroupRequestDto is null");
        return RoomGroup.builder()
                .id(id)
                .name(roomGroupRequestDto.name())
                .description(roomGroupRequestDto.description())
                .available(roomGroupRequestDto.available())
                .build();
    }

    public static Page<RoomGroupResponseDto> toRoomGroupResponseDtoPage(Page<RoomGroup> roomGroups) {
        if (roomGroups == null) throw new MapperException("Page<RoomGroup> is null");
        return roomGroups.map(RoomGroupMapper::toRoomGroupResponseDto);
    }

}
