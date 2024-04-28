package com.sovliv.twitter.security.service.impl;

import com.sovliv.twitter.security.model.UserAccount;
import com.sovliv.twitter.security.repository.UserAccountRepository;
import com.sovliv.twitter.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public void createUserAccount(UserAccount userAccount) {
        if (this.userAccountRepository.existsByUsername(userAccount.getUsername())){
            throw new RuntimeException("Account with username %s already exists!".formatted(userAccount.getUsername()));
        }
        this.userAccountRepository.save(userAccount);
    }
}
