package pl.wj.bookingmanager.domain.commentprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CommentRequestDto (
        @NotBlank(message = "{comment.title.not-blank}")
        String title,
        @NotBlank(message = "{comment.body.not-blank}")
        String body) {}
