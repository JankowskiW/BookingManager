package pl.wj.bookingmanager.domain.roomprocessor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
