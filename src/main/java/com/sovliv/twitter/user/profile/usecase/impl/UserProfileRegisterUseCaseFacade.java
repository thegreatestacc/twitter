package com.sovliv.twitter.user.profile.usecase.impl;

import com.sovliv.twitter.user.profile.UserProfile;
import com.sovliv.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.sovliv.twitter.user.profile.service.UserProfileService;
import com.sovliv.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import com.sovliv.twitter.user.profile.web.model.UserProfileRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    @Override
    public void registerUserProfile(UserProfileRegisterRequest request) {
        UserProfile userProfile = this.mapper.map(request);
        this.userProfileService.createUserProfile(userProfile);
    }
}
