package pl.wj.bookingmanager.domain.commentprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.Comment;
import pl.wj.bookingmanager.domain.commentprocessor.model.CommentMapper;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;

@Service
@RequiredArgsConstructor
public class CommentProcessorService {
    private final SecurityService securityService;
    private final CommentRepository commentRepository;

    public CommentResponseDto addComment(CommentObjectType commentObjectType, CommentRequestDto commentRequestDto) {
        User createdByUser = securityService.getAuthenticatedUser();
        Comment comment = CommentMapper.toComment(createdByUser, commentObjectType, commentRequestDto);
        comment = commentRepository.save(comment);
        return CommentMapper.toCommentResponseDto(comment);
    }
}
