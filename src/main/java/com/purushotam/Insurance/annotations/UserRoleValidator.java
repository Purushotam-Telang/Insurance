package com.purushotam.Insurance.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UserRoleValidator implements ConstraintValidator<UserRoleValidation, String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        List<String> userRoles = List.of("ADMIN","USER","TEST");
        return userRoles.contains(inputRole);
    }

}
