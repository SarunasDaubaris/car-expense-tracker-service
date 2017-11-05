package com.personalgarage.service.main.users.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class UsersErrors {

    public static final ErrorData USERNAME_EMPTY = new ErrorData(ErrorCodeBases.USERS, 1, "Username is empty");
    public static final ErrorData PASSWORD_EMPTY = new ErrorData(ErrorCodeBases.USERS, 2, "Password is empty");
    public static final ErrorData USERNAME_TAKEN = new ErrorData(ErrorCodeBases.USERS, 3, "Username already taken");

    private UsersErrors() {
    }
}