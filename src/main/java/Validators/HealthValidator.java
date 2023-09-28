package Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HealthValidator implements ConstraintValidator<ValidHealth, Integer> {
    
    @Override
    public boolean isValid(Integer health, ConstraintValidatorContext context) {
        // Здесь вы можете определить логику валидации для значения health
        // Например, проверить, что значение находится в допустимом диапазоне

        // В данном примере, предположим, что допустимый диапазон от 0 до 100
        return health >= 0 && health <= 100;
    }
}
