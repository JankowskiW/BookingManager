package pl.wj.bookingmanager.domain.deviceprocessor.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
