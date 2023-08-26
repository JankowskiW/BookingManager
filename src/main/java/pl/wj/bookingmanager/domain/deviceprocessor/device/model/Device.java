package pl.wj.bookingmanager.domain.deviceprocessor.device.model;

import jakarta.persistence.*;
import pl.wj.bookingmanager.domain.groupprocessor.devicegroup.model.DeviceGroup;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(columnDefinition = "bit default 1")  // boolean default true
    private boolean available;

    @ManyToMany(mappedBy = "devices")
    private Set<DeviceGroup> groups = new HashSet<>();
}
