package com.sovliv.twitter.security.usecase;

import com.sovliv.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import com.sovliv.twitter.security.model.UserAccount;
import com.sovliv.twitter.security.service.UserAccountService;
import com.sovliv.twitter.security.web.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {

    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = mapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }
}
