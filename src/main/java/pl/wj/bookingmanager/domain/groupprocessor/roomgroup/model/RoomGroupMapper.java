package pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model;

import org.springframework.data.domain.Page;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.dto.RoomGroupUpdateRequestDto;

public class RoomGroupMapper {
    public static RoomGroup toRoomGroup(RoomGroupRequestDto roomGroupRequestDto) {
        return RoomGroup.builder()
                .name(roomGroupRequestDto.name())
                .description(roomGroupRequestDto.description())
                .build();
    }

    public static RoomGroupResponseDto toRoomGroupResponseDto(RoomGroup roomGroup) {
        return RoomGroupResponseDto.builder()
                .id(roomGroup.getId())
                .name(roomGroup.getName())
                .description(roomGroup.getDescription())
                .build();
    }

    public static RoomGroup toRoomGroup(long id, RoomGroupUpdateRequestDto roomGroupUpdateRequestDto) {
        return RoomGroup.builder()
                .id(id)
                .name(roomGroupUpdateRequestDto.name())
                .description(roomGroupUpdateRequestDto.description())
                .build();
    }

    public static Page<RoomGroupResponseDto> toRoomGroupResponseDtoPage(Page<RoomGroup> roomGroups) {
        return roomGroups.map(RoomGroupMapper::toRoomGroupResponseDto);
    }

}
