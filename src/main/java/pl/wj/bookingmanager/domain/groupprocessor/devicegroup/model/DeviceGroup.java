package pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wj.bookingmanager.domain.deviceprocessor.model.Device;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "device_groups")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeviceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "bit default 1", nullable = false)  // boolean default true
    private boolean available;

    @ManyToMany
    @JoinTable(
            name = "group_devices",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "device_id") }
    )
    @Builder.Default
    private Set<Device> devices = new HashSet<>();
}
