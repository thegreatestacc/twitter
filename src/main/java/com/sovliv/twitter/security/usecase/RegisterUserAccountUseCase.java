package com.sovliv.twitter.security.usecase;

import com.sovliv.twitter.security.web.model.RegisterRequest;

public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
