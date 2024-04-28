package com.sovliv.twitter.security.mapper.impl;

import com.sovliv.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import com.sovliv.twitter.security.model.UserAccount;
import com.sovliv.twitter.security.model.UserRole;
import com.sovliv.twitter.security.service.UserRoleService;
import com.sovliv.twitter.security.web.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {

    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccount map(RegisterRequest registerRequest) {
        UserRole userRole = this.userRoleService
                .findUserRole()
                .orElseThrow(() -> new RuntimeException("User role not found!"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(this.passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));

        return userAccount;
    }
}
