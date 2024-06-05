package com.sovliv.twitter.security.api.service.impl;

import com.sovliv.twitter.security.api.model.CurrentUserApiModel;
import com.sovliv.twitter.security.api.service.IdentityApiService;
import com.sovliv.twitter.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {

    private final UserAccountService userAccountService;

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        return Optional.ofNullable(securityContext.getAuthentication())
                .map(Authentication::getName)
                .flatMap(this::extractCurrentUserApiModel);
    }

    private Optional<CurrentUserApiModel> extractCurrentUserApiModel(String username) {
        return this.userAccountService.findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }
}
