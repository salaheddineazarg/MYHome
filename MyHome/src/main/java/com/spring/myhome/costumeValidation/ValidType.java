package com.spring.myhome.costumeValidation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidTypeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidType {
    String message() default "Invalid type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
