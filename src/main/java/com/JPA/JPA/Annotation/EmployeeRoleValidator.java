package com.JPA.JPA.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("null") || value.isBlank()){
            return false;
        }
        return value.equalsIgnoreCase("user") || value.equalsIgnoreCase("admin");
    }
}
