package pl.wj.bookingmanager.domain.groupprocessor.grouptype.model;

import jakarta.persistence.*;

@Entity
@Table(name = "group_types")
public class GroupType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
