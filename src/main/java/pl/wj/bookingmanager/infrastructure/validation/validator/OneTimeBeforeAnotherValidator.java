package pl.wj.bookingmanager.infrastructure.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import pl.wj.bookingmanager.infrastructure.validation.constraint.OneTimeBeforeAnother;

import java.time.LocalDateTime;

public class OneTimeBeforeAnotherValidator
        implements ConstraintValidator<OneTimeBeforeAnother, Object> {

    private String firstField;
    private String secondField;
    private int minimumMinutesDuration;

    @Override
    public void initialize(OneTimeBeforeAnother constraintAnnotation) {
        this.firstField = constraintAnnotation.firstField();
        this.secondField = constraintAnnotation.secondField();
        this.minimumMinutesDuration = constraintAnnotation.minimumMinutesDuration();
    }

    @Override
    public boolean isValid(Object o,
                           ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime firstFieldValue = (LocalDateTime) new BeanWrapperImpl(o).getPropertyValue(firstField);
        LocalDateTime secondFieldValue = (LocalDateTime) new BeanWrapperImpl(o).getPropertyValue(secondField);

        if (firstFieldValue == null || secondFieldValue == null) return false;
        return !firstFieldValue.plusMinutes(minimumMinutesDuration).isAfter(secondFieldValue);
    }
}
