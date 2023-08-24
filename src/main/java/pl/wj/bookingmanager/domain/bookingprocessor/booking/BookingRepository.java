package pl.wj.bookingmanager.domain.bookingprocessor.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
