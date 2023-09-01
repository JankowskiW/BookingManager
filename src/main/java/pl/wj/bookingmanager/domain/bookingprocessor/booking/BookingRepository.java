package pl.wj.bookingmanager.domain.bookingprocessor.booking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;

import java.time.LocalDateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.startTime <= :now AND b.endTime >= :now")
    Page<Booking> findAllActive(Pageable pageable, LocalDateTime now);

    @Query("SELECT b FROM Booking b WHERE b.startTime > :now")
    Page<Booking> findAllFuture(Pageable pageable, LocalDateTime now);

    @Query("SELECT b FROM Booking b WHERE b.endTime < :now")
    Page<Booking> findAllExpired(Pageable pageable, LocalDateTime now);
}
