package pl.wj.bookingmanager.domain.commentprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;

@RestController
@RequiredArgsConstructor
public class CommentProcessorController {
    private final CommentProcessorService commentProcessorService;

    @PostMapping("/booking/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDto addBookingComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentProcessorService.addComment(CommentObjectType.BOOKING, commentRequestDto);
    }


    @PostMapping("/user/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDto addUserComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentProcessorService.addComment(CommentObjectType.USER, commentRequestDto);
    }
}
