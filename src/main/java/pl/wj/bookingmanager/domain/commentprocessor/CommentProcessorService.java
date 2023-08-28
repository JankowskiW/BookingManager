package pl.wj.bookingmanager.domain.commentprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.domain.commentprocessor.model.Comment;
import pl.wj.bookingmanager.domain.commentprocessor.model.CommentMapper;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.BookingCommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.UserCommentRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;

@Service
@RequiredArgsConstructor
public class CommentProcessorService {
    private final SecurityService securityService;
    private final CommentRepository commentRepository;

    private CommentResponseDto addComment(Comment comment) {
        return CommentMapper.toCommentResponseDto(commentRepository.save(comment));
    }

    public CommentResponseDto addComment(BookingCommentRequestDto bookingCommentRequestDto) {
        User createdByUser = securityService.getAuthenticatedUser();
        Comment comment = CommentMapper.toComment(createdByUser, bookingCommentRequestDto);
        return addComment(comment);
    }

    public CommentResponseDto addComment(UserCommentRequestDto userCommentRequestDto) {
        User createdByUser = securityService.getAuthenticatedUser();
        Comment comment = CommentMapper.toComment(createdByUser, userCommentRequestDto);
        return addComment(comment);
    }
}
