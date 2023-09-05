package pl.wj.bookingmanager.domain.commentprocessor.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CommentRequestDto (
        @NotNull(message = "{comment.comment-object-id.not-null}")
        @Min(value = 1, message = "{comment.comment-object-id.int-greater-than-0}")
        int commentObjectId,
        @NotBlank(message = "{comment.title.not-blank}")
        String title,
        @NotBlank(message = "{comment.body.not-blank}")
        String body) {}
