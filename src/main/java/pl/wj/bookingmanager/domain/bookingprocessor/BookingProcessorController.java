package pl.wj.bookingmanager.domain.bookingprocessor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wj.bookingmanager.domain.commentprocessor.CommentProcessorService;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.BookingCommentRequestDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.CommentResponseDto;
import pl.wj.bookingmanager.domain.commentprocessor.model.dto.UserCommentRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingProcessorController {
    private final BookingProcessorService bookingProcessorService;
    private final CommentProcessorService commentProcessorService;

    @PostMapping("/comment/a")
    public CommentResponseDto addCommentA(@RequestBody BookingCommentRequestDto bookingCommentRequestDto) {
        return commentProcessorService.addComment(bookingCommentRequestDto);
    }
    @PostMapping("/comment/b")
    public CommentResponseDto addCommentB(@RequestBody UserCommentRequestDto userCommentRequestDto) {
        return commentProcessorService.addComment(userCommentRequestDto);
    }
}
