package pl.wj.bookingmanager.domain.bookingprocessor.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import pl.wj.bookingmanager.infrastructure.validation.constraint.NotInThePast;
import pl.wj.bookingmanager.infrastructure.validation.constraint.OneTimeBeforeAnother;

import java.time.LocalDateTime;


@Builder
@OneTimeBeforeAnother(
        firstField = "startTime",
        secondField = "endTime",
        minimumMinutesDuration = 10,
        message = "{booking.duration.longer-than}"
)
public record BookingRequestDto (
        @NotBlank(message = "{booking.title.not-blank")
        String title,
        @NotNull(message = "{booking.description.not-null")
        String description,
        @NotNull(message = "{booking.start-time.not-null")
        @NotInThePast(message = "{booking.start-time.not-in-the-past}")
        LocalDateTime startTime,
        @NotNull(message = "{booking.end-time.not-null")
        @NotInThePast(message = "{booking.end-time.not-in-the-past}")
        LocalDateTime endTime
) {}
