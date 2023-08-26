package pl.wj.bookingmanager.domain.lockprocessor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locks")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Lock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
