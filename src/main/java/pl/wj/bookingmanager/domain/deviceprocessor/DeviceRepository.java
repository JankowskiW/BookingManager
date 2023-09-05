package pl.wj.bookingmanager.domain.deviceprocessor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.deviceprocessor.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Page<Device> findAllByAvailable(boolean available, Pageable pageable);
}
