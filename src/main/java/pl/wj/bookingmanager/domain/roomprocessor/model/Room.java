package pl.wj.bookingmanager.domain.roomprocessor.model;

import jakarta.persistence.*;
import lombok.*;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.RoomGroup;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String location; // TODO: think about it.. maybe it will be better to put some enum or sth like that here instead of string
    @Column(columnDefinition = "bit default 1", nullable = false)
    private boolean available;
    @ManyToMany(mappedBy = "rooms")
    private Set<RoomGroup> groups = new HashSet<>();
    @OneToMany(mappedBy = "room")
    private Set<Booking> bookings = new HashSet<>();
}
