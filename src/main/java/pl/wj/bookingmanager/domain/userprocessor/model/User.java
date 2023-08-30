package pl.wj.bookingmanager.domain.userprocessor.model;

import jakarta.persistence.*;
import lombok.*;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;
import pl.wj.bookingmanager.domain.commentprocessor.model.Comment;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String emailAddress;
    @Column(columnDefinition = "bit default 0", nullable = false)
    private boolean archived;
    @OneToMany(mappedBy = "createdByUser")
    private Set<Booking> createdBookings = new HashSet<>();
    @OneToMany(mappedBy = "updatedByUser")
    private Set<Booking> updatedBookings = new HashSet<>();
    @OneToMany(mappedBy = "createdByUser")
    private Set<Comment> createdComments = new HashSet<>();

    public static User createWithId(long id) {
        User user = new User();
        user.id = id;
        return user;
    }
}
