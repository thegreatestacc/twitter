package com.sovliv.twitter.security.service.impl;

import com.sovliv.twitter.security.model.UserAccount;
import com.sovliv.twitter.security.repository.UserAccountRepository;
import com.sovliv.twitter.security.service.UserAccountService;
import com.sovliv.twitter.security.web.exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public void createUserAccount(UserAccount userAccount) {
        if (this.userAccountRepository.existsByUsername(userAccount.getUsername())){
            throw new UserAlreadyExistException(userAccount.getUsername());
        }
        this.userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findUserByUsername(String username) {
        return this.userAccountRepository.findByUsername(username);
    }
}
