package pl.wj.bookingmanager.domain.groupprocessor.devicegroup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.DeviceGroup;

@Repository
public interface DeviceGroupRepository extends JpaRepository<DeviceGroup, Long> {
    Page<DeviceGroup> findAllByAvailable(boolean available, Pageable pageable);
}
