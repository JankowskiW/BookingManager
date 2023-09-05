package pl.wj.bookingmanager.domain.commentprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.Comment;
import pl.wj.bookingmanager.domain.commentprocessor.model.CommentMapper;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentProcessorService {
    private final CommentRepository commentRepository;

    public CommentResponseDto addComment(long commentObjectId,
                                         long createdByUserId,
                                         CommentObjectType commentObjectType,
                                         CommentRequestDto commentRequestDto) {
        Comment comment = CommentMapper.toComment(commentObjectId, createdByUserId, commentObjectType, commentRequestDto);
        comment = commentRepository.save(comment);
        return CommentMapper.toCommentResponseDto(comment);
    }

    public Set<CommentResponseDto> getCommentsByObjectIdAndObjectType(long id, CommentObjectType booking) {
        Set<Comment> comments = commentRepository.findAllByCommentObjectIdAndCommentObjectTypeId(id, booking.getId());
        return CommentMapper.toCommentResponseDtos(comments);
    }
}
