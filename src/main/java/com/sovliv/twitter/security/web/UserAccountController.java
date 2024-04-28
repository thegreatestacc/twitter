package com.sovliv.twitter.security.web;

import com.sovliv.twitter.security.model.UserAccount;
import com.sovliv.twitter.security.model.UserRole;
import com.sovliv.twitter.security.service.UserAccountService;
import com.sovliv.twitter.security.service.UserRoleService;
import com.sovliv.twitter.security.web.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        Assert.hasLength(registerRequest.username(), "Username must not be null or empty!");
        Assert.hasLength(registerRequest.password(), "Password must not be null or empty!");

        UserRole userRole = this.userRoleService
                .findUserRole()
                .orElseThrow(() -> new RuntimeException("User role not found!"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(this.passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));

        this.userAccountService.createUserAccount(userAccount);
    }
}
