package pl.wj.bookingmanager.domain.commentprocessor.model.dto;

import lombok.Builder;

@Builder
public record CommentResponseDto(
        long id,
        int commentObjectTypeId,
        int commentObjectId,
        String title,
        String body
) { }
