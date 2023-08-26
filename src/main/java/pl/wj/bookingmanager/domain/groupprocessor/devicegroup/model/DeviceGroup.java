package pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model;

import jakarta.persistence.*;
import pl.wj.bookingmanager.domain.deviceprocessor.device.model.Device;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "device_groups")
public class DeviceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_devices",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "device_id") }
    )
    private Set<Device> devices = new HashSet<>();
}
