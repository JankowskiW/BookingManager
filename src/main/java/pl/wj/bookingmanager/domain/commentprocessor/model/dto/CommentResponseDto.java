package pl.wj.bookingmanager.domain.commentprocessor.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentResponseDto(
        long id,
        int commentObjectTypeId,
        int commentObjectId,
        String title,
        String body,
        long createdBy,
        LocalDateTime createdAt
) { }
