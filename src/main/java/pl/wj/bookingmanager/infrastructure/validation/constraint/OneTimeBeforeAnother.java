package pl.wj.bookingmanager.infrastructure.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.wj.bookingmanager.infrastructure.validation.validator.OneTimeBeforeAnotherValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OneTimeBeforeAnotherValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OneTimeBeforeAnother {
    String message() default "First time has to be before the second time";
    String firstField();
    String secondField();
    int minimumMinutesDuration();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        OneTimeBeforeAnother[] value();
    }
}
