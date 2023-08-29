package pl.wj.bookingmanager.domain.commentprocessor.model.dto;

import lombok.Builder;

@Builder
public record CommentRequestDto (
        int commentObjectId,
        String title,
        String body) {}
