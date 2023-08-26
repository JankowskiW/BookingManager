package pl.wj.bookingmanager.domain.groupprocessor.roomgroup.model;

import jakarta.persistence.*;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "room_groups")

public class RoomGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_rooms",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "room_id") }
    )
    private Set<Room> rooms = new HashSet<>();
}
