package pl.wj.bookingmanager.domain.commentprocessor.model;

import pl.wj.bookingmanager.common.enumerator.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.infrastructure.exception.ExceptionMessage;
import pl.wj.bookingmanager.infrastructure.exception.definition.MapperException;

import java.util.Set;
import java.util.stream.Collectors;

public class CommentMapper {

    public static CommentResponseDto toCommentResponseDto(Comment comment) {
        if (comment == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Comment"));
        return CommentResponseDto.builder()
                .id(comment.getId())
                .commentObjectTypeId(comment.getCommentObjectTypeId())
                .commentObjectId(comment.getCommentObjectId())
                .title(comment.getTitle())
                .body(comment.getBody())
                .createdAt(comment.getCreatedAt())
                .createdBy(comment.getCreatedByUser().getId())
                .createdByUsername(comment.getCreatedByUser().getUsername())
                .build();
    }
    public static Comment toComment(long commentObjectId, long createdBy, CommentObjectType commentObjectType, CommentRequestDto commentRequestDto) {
        if (commentObjectType == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "CommentObjectType"));
        if (commentRequestDto == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "CommentRequestDto"));
        return Comment.builder()
                .title(commentRequestDto.title())
                .body(commentRequestDto.body())
                .commentObjectId(commentObjectId)
                .commentObjectTypeId(commentObjectType.getId())
                .createdByUser(User.builder().id(createdBy).build())
                .build();
    }

    public static Set<CommentResponseDto> toCommentResponseDtos(Set<Comment> comments) {
        if (comments == null)
            throw new MapperException(ExceptionMessage.getMapperMessage("null", "Set<Comment>"));
        return comments.stream().map(CommentMapper::toCommentResponseDto).collect(Collectors.toSet());
    }
}
