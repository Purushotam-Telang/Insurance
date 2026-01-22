package com.purushotam.Insurance.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UserRoleValidator.class})
public @interface UserRoleValidation {
    String message() default "User role should be ADMIN,USER or TEST";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
