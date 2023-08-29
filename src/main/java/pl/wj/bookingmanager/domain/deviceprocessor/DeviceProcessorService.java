package pl.wj.bookingmanager.domain.deviceprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.deviceprocessor.device.DeviceRepository;
import pl.wj.bookingmanager.infrastructure.exception.definition.ResourceNotFoundException;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DeviceProcessorService {
    private final DeviceRepository deviceRepository;

    public void throwIfNotExistsById(Long id) {
        if(!deviceRepository.existsById(id))
            throw new ResourceNotFoundException("Device with id " + id + " does not exist");
    }
    public void throwIfNotExistsById(Set<Long> ids) {
        ids.forEach(this::throwIfNotExistsById);
    }
}
