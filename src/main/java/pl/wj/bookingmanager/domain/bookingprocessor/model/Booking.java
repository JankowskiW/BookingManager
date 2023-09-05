package pl.wj.bookingmanager.domain.bookingprocessor.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.wj.bookingmanager.domain.deviceprocessor.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = false)
    private long createdBy;
    @Column(nullable = false)
    private long updatedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", updatable = false, insertable = false)
    private Room room;
    @ManyToMany
    @JoinTable(
            name = "booking_devices",
            joinColumns = { @JoinColumn(name = "booking_id", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "device_id", insertable = false, updatable = false) }
    )
    private Set<Device> devices = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        return id == booking.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }


}
