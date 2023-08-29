package pl.wj.bookingmanager.domain.roomprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class RoomProcessorService {
    private final RoomRepository roomRepository;

    public void throwIfNotExistsById(long id) {
        if(!roomRepository.existsById(id))
            throw new ResourceNotFoundException("Room with id " + id + " does not exist");
    }
}
