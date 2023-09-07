package pl.wj.bookingmanager.domain.roomprocessor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Page<Room> findAllByAvailable(boolean available, Pageable pageable);
}
