package pl.wj.bookingmanager.domain.roomprocessor.model;

import jakarta.persistence.*;
import pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model.RoomGroup;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "rooms")
    private Set<RoomGroup> groups = new HashSet<>();
}
