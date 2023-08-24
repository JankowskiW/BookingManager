package pl.wj.bookingmanager.domain.groupprocessor.groupobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.groupprocessor.groupobject.model.GroupObject;

@Repository
public interface GroupObjectRepository extends JpaRepository<GroupObject, Long> {
}
