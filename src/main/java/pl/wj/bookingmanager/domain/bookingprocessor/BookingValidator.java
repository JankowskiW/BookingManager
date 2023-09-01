package pl.wj.bookingmanager.domain.bookingprocessor;

import pl.wj.bookingmanager.infrastructure.exception.definition.BadRequestException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BookingValidator {
    private static final int MINIMUM_BOOKING_DURATION_IN_MINUTES = 10;
    private static final ChronoUnit TRUNCATE_UNIT = ChronoUnit.MINUTES;

    public static void hasInvalidDurationTime(LocalDateTime startTime, LocalDateTime endTime) {
        startTime = startTime.truncatedTo(TRUNCATE_UNIT);
        endTime = endTime.truncatedTo(TRUNCATE_UNIT);
        if(!endTime.minusMinutes(MINIMUM_BOOKING_DURATION_IN_MINUTES).isBefore(startTime)) return;
        throw new BadRequestException("Given duration time cannot be less than " + MINIMUM_BOOKING_DURATION_IN_MINUTES + " minutes");
    }

    public static void isBeforeCurrentDateTime(LocalDateTime time) {
        time = time.truncatedTo(TRUNCATE_UNIT);
        LocalDateTime now = LocalDateTime.now().truncatedTo(TRUNCATE_UNIT);
        if(now.isBefore(time)) return;
        throw new BadRequestException("Given time cannot be before the current time");
    }
}
