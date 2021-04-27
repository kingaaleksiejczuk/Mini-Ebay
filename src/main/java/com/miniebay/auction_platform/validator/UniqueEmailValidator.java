package com.miniebay.auction_platform.validator;

import com.miniebay.auction_platform.helper.DataHelper;
import com.miniebay.auction_platform.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private UserService userService;
    private DataHelper dataHelper;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    public void initialize(UniqueEmail constraint) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return dataHelper.isEmailUnique(email);
    }

}
