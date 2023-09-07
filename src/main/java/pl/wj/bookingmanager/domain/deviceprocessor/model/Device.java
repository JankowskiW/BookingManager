package pl.wj.bookingmanager.domain.deviceprocessor.model;

import jakarta.persistence.*;
import lombok.*;
import pl.wj.bookingmanager.domain.bookingprocessor.model.Booking;
import pl.wj.bookingmanager.domain.devicegroupprocessor.model.DeviceGroup;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        return id == device.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
