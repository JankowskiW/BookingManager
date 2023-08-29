package pl.wj.bookingmanager.domain.commentprocessor.model;

import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

public class CommentMapper {

    public static CommentResponseDto toCommentResponseDto(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .commentObjectTypeId(comment.getCommentObjectTypeId())
                .commentObjectId(comment.getCommentObjectId())
                .title(comment.getTitle())
                .body(comment.getBody())
                .build();
    }

    public static Comment toComment(User createdByUser, CommentObjectType commentObjectType, CommentRequestDto commentRequestDto) {
        return Comment.builder()
                .title(commentRequestDto.title())
                .body(commentRequestDto.body())
                .commentObjectId(commentRequestDto.commentObjectId())
                .commentObjectTypeId(commentObjectType.getId())
                .createdByUser(createdByUser)
                .build();
    }
}
