package pl.wj.bookingmanager.domain.commentprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.CommentObjectType;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentProcessorController {
    private final CommentProcessorService commentProcessorService;

    @PostMapping("/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDto addBookingComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentProcessorService.addComment(CommentObjectType.BOOKING, commentRequestDto);
    }


    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDto addUserComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentProcessorService.addComment(CommentObjectType.USER, commentRequestDto);
    }
}
