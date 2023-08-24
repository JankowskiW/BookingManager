package pl.wj.bookingmanager.domain.groupprocessor.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.groupprocessor.group.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
