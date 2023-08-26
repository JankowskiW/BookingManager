package pl.wj.bookingmanager.domain.lockprocessor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.lockprocessor.model.Lock;

@Repository
public interface LockRepository extends JpaRepository<Lock, Long> {
}
