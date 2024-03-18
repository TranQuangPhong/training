package phong.customvalidator;

import phong.annotation.ValidId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidIdCustomValidator implements ConstraintValidator<ValidId, String> {
    private static final String VALID_ID_PREFIX = "http://";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty())
            return false;
        return s.startsWith(VALID_ID_PREFIX);
    }
}
