package pl.wj.bookingmanager.domain.roomprocessor.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String location; // TODO: change that location to long locationId which is PK from locations table
    @Column(columnDefinition = "bit default 1", nullable = false)
    private boolean available;
}
