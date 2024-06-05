package com.sovliv.twitter.user.profile.web;

import com.sovliv.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import com.sovliv.twitter.user.profile.web.model.UserProfileRegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileRegisterUseCase registerUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest request) {
        this.registerUseCase.registerUserProfile(request);
    }
}
