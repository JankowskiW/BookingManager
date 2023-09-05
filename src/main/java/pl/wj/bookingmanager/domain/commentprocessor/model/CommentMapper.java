package pl.wj.bookingmanager.domain.commentprocessor.model;

import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;

public class CommentMapper {

    public static CommentResponseDto toCommentResponseDto(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .commentObjectTypeId(comment.getCommentObjectTypeId())
                .commentObjectId(comment.getCommentObjectId())
                .title(comment.getTitle())
                .body(comment.getBody())
                .createdAt(comment.getCreatedAt())
                .createdBy(comment.getCreatedBy())
                .build();
    }

    public static Comment toComment(long commentObjectId, long createdBy, CommentObjectType commentObjectType, CommentRequestDto commentRequestDto) {
        return Comment.builder()
                .title(commentRequestDto.title())
                .body(commentRequestDto.body())
                .commentObjectId(commentObjectId)
                .commentObjectTypeId(commentObjectType.getId())
                .createdBy(createdBy)
                .build();
    }
}
