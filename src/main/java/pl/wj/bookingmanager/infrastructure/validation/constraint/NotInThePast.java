package pl.wj.bookingmanager.infrastructure.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.wj.bookingmanager.infrastructure.validation.validator.NotInThePastValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = NotInThePastValidator.class)
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface NotInThePast {
    String message() default "Time should not be in the past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
