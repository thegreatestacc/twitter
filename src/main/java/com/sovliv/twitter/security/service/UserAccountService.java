package com.sovliv.twitter.security.service;

import com.sovliv.twitter.security.model.UserAccount;

import java.util.Optional;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);

    Optional<UserAccount> findUserByUsername(String username);
}
