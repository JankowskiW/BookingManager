package pl.wj.bookingmanager.domain.groupprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.DeviceGroupRepository;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.RoomGroupRepository;

@Service
@RequiredArgsConstructor
public class GroupProcessorService {
    private final DeviceGroupRepository deviceGroupRepository;
    private final RoomGroupRepository roomGroupRepository;
}
