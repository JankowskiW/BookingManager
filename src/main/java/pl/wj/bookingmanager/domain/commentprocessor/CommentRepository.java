package pl.wj.bookingmanager.domain.commentprocessor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wj.bookingmanager.domain.commentprocessor.model.Comment;

import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Set<Comment> findAllByCommentObjectIdAndCommentObjectTypeId(long id, int id1);
}
