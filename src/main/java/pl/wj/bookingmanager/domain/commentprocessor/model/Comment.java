package pl.wj.bookingmanager.domain.commentprocessor.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int commentObjectTypeId;
    private int commentObjectId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name="created_by", nullable = false)
    private User createdByUser;

}
