package pl.wj.bookingmanager.infrastructure.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.wj.bookingmanager.infrastructure.validation.constraint.NotInThePast;

import java.time.LocalDateTime;

public class NotInThePastValidator implements ConstraintValidator<NotInThePast, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime t, ConstraintValidatorContext constraintValidatorContext) {
        return !LocalDateTime.now().isAfter(t);
    }
}
