package pl.wj.bookingmanager.domain.deviceprocessor.device.model;

import jakarta.persistence.*;
import lombok.*;
import pl.wj.bookingmanager.domain.bookingprocessor.booking.model.Booking;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.DeviceGroup;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "bit default 1", nullable = false)  // boolean default true
    private boolean available;

    @ManyToMany(mappedBy = "devices")
    private Set<DeviceGroup> groups = new HashSet<>();
    @ManyToMany(mappedBy = "devices")
    private Set<Booking> bookings = new HashSet<>();
}
