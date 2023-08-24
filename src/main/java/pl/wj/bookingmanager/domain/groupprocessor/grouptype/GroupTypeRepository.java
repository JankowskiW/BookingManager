package pl.wj.bookingmanager.domain.groupprocessor.grouptype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.groupprocessor.grouptype.model.GroupType;

@Repository
public interface GroupTypeRepository extends JpaRepository<GroupType, Long> {
}
