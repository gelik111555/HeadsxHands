package Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HealthValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidHealth {
    String message() default "Недопустимое значение здоровья";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}