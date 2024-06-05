package com.sovliv.twitter.security.web.exceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUsernameNotFoundException extends UsernameNotFoundException {

    private final static String USER_NAME_NOT_FOUND_EXCEPTION_MESSAGE = "Bad credentials for user %s !";


    public CustomUsernameNotFoundException(String username) {
        super(USER_NAME_NOT_FOUND_EXCEPTION_MESSAGE.formatted(username));
    }
}
