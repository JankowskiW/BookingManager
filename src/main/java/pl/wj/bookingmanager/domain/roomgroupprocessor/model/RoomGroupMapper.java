package pl.wj.bookingmanager.domain.roomgroupprocessor.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.ExceptionMessage;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

public class RoomGroupMapper {
    public static RoomGroup toRoomGroup(RoomGroupRequestDto roomGroupRequestDto) {
        if (roomGroupRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "RoomGroupRequestDto"));
        return RoomGroup.builder()
                .name(roomGroupRequestDto.name())
                .description(roomGroupRequestDto.description())
                .available(roomGroupRequestDto.available())
                .build();
    }

    public static RoomGroupResponseDto toRoomGroupResponseDto(RoomGroup roomGroup) {
        if (roomGroup == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "RoomGroup"));
        return RoomGroupResponseDto.builder()
                .id(roomGroup.getId())
                .name(roomGroup.getName())
                .description(roomGroup.getDescription())
                .available(roomGroup.isAvailable())
                .build();
    }

    public static RoomGroup toRoomGroup(long id, RoomGroupRequestDto roomGroupRequestDto) {
        if (roomGroupRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "RoomGroupRequestDto"));
        return RoomGroup.builder()
                .id(id)
                .name(roomGroupRequestDto.name())
                .description(roomGroupRequestDto.description())
                .available(roomGroupRequestDto.available())
                .build();
    }

    public static Page<RoomGroupResponseDto> toRoomGroupResponseDtoPage(Page<RoomGroup> roomGroups) {
        if (roomGroups == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Page<RoomGroup>"));
        return roomGroups.map(RoomGroupMapper::toRoomGroupResponseDto);
    }

}
