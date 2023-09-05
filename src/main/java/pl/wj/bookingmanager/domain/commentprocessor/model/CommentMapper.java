package pl.wj.bookingmanager.domain.commentprocessor.model;

import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class CommentMapper {

    public static CommentResponseDto toCommentResponseDto(Comment comment) {
        if (comment == null) return null;
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
        if (commentObjectType == null || commentRequestDto == null) return null;
        return Comment.builder()
                .title(commentRequestDto.title())
                .body(commentRequestDto.body())
                .commentObjectId(commentObjectId)
                .commentObjectTypeId(commentObjectType.getId())
                .createdByUser(User.builder().id(createdBy).build())
                .build();
    }

    public static Set<CommentResponseDto> toCommentResponseDtos(Set<Comment> comments) {
        if (comments == null) return null;
        return comments.stream().map(CommentMapper::toCommentResponseDto).collect(Collectors.toSet());
    }
}
