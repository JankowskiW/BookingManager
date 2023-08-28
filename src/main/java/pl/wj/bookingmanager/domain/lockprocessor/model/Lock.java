package pl.wj.bookingmanager.domain.lockprocessor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "locks")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Lock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
