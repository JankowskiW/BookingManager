package pl.wj.bookingmanager.domain.bookingprocessor.booking.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import pl.wj.bookingmanager.infrastructure.validation.constraint.OneTimeBeforeAnother;

import java.time.LocalDateTime;


@Builder
@OneTimeBeforeAnother(
        firstField = "startTime",
        secondField = "endTime",
        minimumMinutesDuration = 10,
        message = "Start time has to be before the end time"
)
public record BookingRequestDto (
        @NotBlank
        String title,
        @NotNull
        String description,
        @NotNull
        LocalDateTime startTime,
        @NotNull
        LocalDateTime endTime
) {}
