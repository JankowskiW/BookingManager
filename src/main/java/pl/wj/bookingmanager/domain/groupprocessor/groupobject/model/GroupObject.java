package pl.wj.bookingmanager.domain.groupprocessor.groupobject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "group_objects")
public class GroupObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
