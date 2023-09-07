package pl.wj.bookingmanager.domain.roomgroupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.RoomGroup;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.RoomGroupMapper;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto.RoomGroupRequestDto;
import pl.wj.bookingmanager.domain.roomgroupprocessor.model.dto.RoomGroupResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomGroupProcessorService {
    private final RoomGroupRepository roomGroupRepository;

    public RoomGroupResponseDto addRoomGroup(RoomGroupRequestDto roomGroupRequestDto) {
        RoomGroup roomGroup = RoomGroupMapper.toRoomGroup(roomGroupRequestDto);
        roomGroup = roomGroupRepository.save(roomGroup);
        return RoomGroupMapper.toRoomGroupResponseDto(roomGroup);
    }

    public RoomGroupResponseDto updateRoomGroup(long id, RoomGroupRequestDto roomGroupRequestDto) {
        if (!roomGroupRepository.existsById(id))
            throw new ResourceNotFoundException("Room group with id " + id + " does not exist");
        RoomGroup roomGroup = RoomGroupMapper.toRoomGroup(id, roomGroupRequestDto);
        roomGroup = roomGroupRepository.save(roomGroup);
        return RoomGroupMapper.toRoomGroupResponseDto(roomGroup);
    }

    public Page<RoomGroupResponseDto> getRoomGroups(AvailabilityStatus availabilityStatus, Pageable pageable) {
        Page<RoomGroup> roomGroups = new PageImpl<>(List.of());
        switch (availabilityStatus) {
            case ALL -> roomGroups = roomGroupRepository.findAll(pageable);
            case AVAILABLE, UNAVAILABLE ->
                    roomGroups = roomGroupRepository.findAllByAvailable(availabilityStatus.getAvailable(), pageable);
        }
        return RoomGroupMapper.toRoomGroupResponseDtoPage(roomGroups);
    }
}
