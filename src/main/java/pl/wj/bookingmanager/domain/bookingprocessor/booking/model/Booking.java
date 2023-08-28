package pl.wj.bookingmanager.domain.bookingprocessor.booking.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;
import pl.wj.bookingmanager.domain.roomprocessor.model.Room;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bookings")
@EqualsAndHashCode
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

    @ManyToOne
    @JoinColumn(name="created_by", nullable = false)
    private User createdByUser;
    @ManyToOne
    @JoinColumn(name="updated_by", nullable = false)
    private User updatedByUser;
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    @ManyToMany
    @JoinTable(
            name = "booking_devices",
            joinColumns = { @JoinColumn(name = "booking_id") },
            inverseJoinColumns = { @JoinColumn(name = "device_id") }
    )
    private Set<Device> devices = new HashSet<>();
}
