package com.sovliv.twitter.security.web;

import com.sovliv.twitter.security.usecase.RegisterUserAccountUseCase;
import com.sovliv.twitter.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserAccountController {

    private final RegisterUserAccountUseCase registerUserAccountUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);
        registerUserAccountUseCase.register(registerRequest);
    }
}
