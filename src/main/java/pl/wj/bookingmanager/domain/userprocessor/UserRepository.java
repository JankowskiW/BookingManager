package pl.wj.bookingmanager.domain.userprocessor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmailAddress(String emailAddress);

    boolean existsByUsernameAndIdIsNot(String username, long id);

    boolean existsByEmailAddressAndIdIsNot(String emailAddress, long id);

    Page<User> findAllByArchived(boolean archived, Pageable pageable);
}
