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
    private String name;
    private String description;
    private String location; // TODO: think about it.. maybe it will be better to put some enum or sth like that here instead of string
    @Column(columnDefinition = "bit default 1")
    private boolean available;

    @ManyToMany(mappedBy = "rooms")
    private Set<RoomGroup> groups = new HashSet<>();
}
