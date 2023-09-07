package pl.wj.bookingmanager.domain.roomprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;
import pl.wj.bookingmanager.domain.roomprocessor.model.RoomMapper;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomRequestDto;
import pl.wj.bookingmanager.domain.roomprocessor.model.dto.RoomResponseDto;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

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

    public Page<RoomResponseDto> getAllRooms(Pageable pageable) {
        Page<Room> rooms = roomRepository.findAll(pageable);
        return RoomMapper.toRoomResponseDtoPage(rooms);
    }

    public Page<RoomResponseDto> getAvailableRooms(Pageable pageable) {
        Page<Room> rooms = roomRepository.findAllByAvailable(true, pageable);
        return RoomMapper.toRoomResponseDtoPage(rooms);
    }

    public Page<RoomResponseDto> getUnavailableRooms(Pageable pageable) {
        Page<Room> rooms = roomRepository.findAllByAvailable(false, pageable);
        return RoomMapper.toRoomResponseDtoPage(rooms);
    }
}
