package com.personalgarage.service.main.users.interfaces.errors;

import com.personalgarage.service.base.errors.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ExceptionData;

public final class UsersErrors {

    public static final ExceptionData USERNAME_EMPTY = new ExceptionData(ErrorCodeBases.USERS, 1, "Username is empty");
    public static final ExceptionData USERNAME_TAKEN = new ExceptionData(ErrorCodeBases.USERS, 2, "Username already taken");
    public static final ExceptionData PASSWORD_EMPTY = new ExceptionData(ErrorCodeBases.USERS, 3, "Password is empty");
    public static final ExceptionData REPEATED_PASSWORD_EMPTY = new ExceptionData(ErrorCodeBases.USERS, 4, "Repeated password is empty");
    public static final ExceptionData PASSWORDS_DO_NOT_MATCH = new ExceptionData(ErrorCodeBases.USERS, 5, "Passwords do not match");

    private UsersErrors() {
    }
}