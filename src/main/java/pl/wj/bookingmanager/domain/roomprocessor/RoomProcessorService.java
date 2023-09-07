package pl.wj.bookingmanager.domain.roomprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.common.enumerator.AvailabilityStatus;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;
import pl.wj.bookingmanager.domain.roomprocessor.model.RoomMapper;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomRequestDto;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomProcessorService {
    private final RoomRepository roomRepository;

    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {
        Room room = RoomMapper.toRoom(roomRequestDto);
        room = roomRepository.save(room);
        return RoomMapper.toRoomResponseDto(room);
    }

    public RoomResponseDto updateRoom(long id, RoomRequestDto roomRequestDto) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Room with id " + id + " does not exist"));
        room = RoomMapper.toRoom(room, roomRequestDto);
        room = roomRepository.save(room);
        return RoomMapper.toRoomResponseDto(room);
    }

    public RoomResponseDto getRoom(long id) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Room with id " + id + " does not exist"));
        return RoomMapper.toRoomResponseDto(room);
    }

    public Page<RoomResponseDto> getRooms(AvailabilityStatus availabilityStatus, Pageable pageable) {
        Page<Room> rooms = new PageImpl<>(List.of());
        switch (availabilityStatus) {
            case ALL -> rooms = roomRepository.findAll(pageable);
            case AVAILABLE, UNAVAILABLE ->
                    rooms = roomRepository.findAllByAvailable(availabilityStatus.getAvailable(), pageable);
        }
        return RoomMapper.toRoomResponseDtoPage(rooms);
    }

}
