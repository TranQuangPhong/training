package phong.annotation;

import phong.customvalidator.ValidIdCustomValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidIdCustomValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidId {
    String message() default "validId must start with http://";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
