package pl.wj.bookingmanager.domain.groupprocessor.roomgroup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.RoomGroup;

@Repository
public interface RoomGroupRepository extends JpaRepository<RoomGroup, Long> {
    Page<RoomGroup> findAllByAvailable(boolean b, Pageable pageable);
}
