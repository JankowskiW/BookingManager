package pl.wj.bookingmanager.domain.bookingprocessor.booking.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bookings")
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime validFrom;
    @Column(nullable = false)
    private LocalDateTime validTo;
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
    private Set<Device> devices;// = new HashSet<>();
}
