package com.sovliv.twitter.security.web.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    private final static String USER_ALREADY_EXIST_EXCEPTION_MESSAGE = "Account with username %s already exist!";

    public UserAlreadyExistException(String username) {
        super(USER_ALREADY_EXIST_EXCEPTION_MESSAGE.formatted(username));
    }
}
