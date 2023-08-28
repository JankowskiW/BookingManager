package pl.wj.bookingmanager.domain.commentprocessor.model;

import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.BookingCommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.UserCommentRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.User;

public class CommentMapper {
    public static Comment toComment(User createdByUser, BookingCommentRequestDto bookingCommentRequestDto) {
        return Comment.builder()
                .title(bookingCommentRequestDto.title())
                .body(bookingCommentRequestDto.body())
                .commentObjectId(bookingCommentRequestDto.commentObjectId())
                .commentObjectTypeId(CommentObjectType.BOOKING.getId())
                .createdByUser(createdByUser)
                .build();
    }

    public static Comment toComment(User createdByUser, UserCommentRequestDto userCommentRequestDto) {
        return Comment.builder()
                .title(userCommentRequestDto.title())
                .body(userCommentRequestDto.body())
                .commentObjectId(userCommentRequestDto.commentObjectId())
                .commentObjectTypeId(CommentObjectType.USER.getId())
                .createdByUser(createdByUser)
                .build();
    }

    public static CommentResponseDto toCommentResponseDto(Comment comment) {
        return CommentResponseDto.builder()
                .id(comment.getId())
                .commentObjectTypeId(comment.getCommentObjectTypeId())
                .commentObjectId(comment.getCommentObjectId())
                .title(comment.getTitle())
                .body(comment.getBody())
                .build();
    }
}
