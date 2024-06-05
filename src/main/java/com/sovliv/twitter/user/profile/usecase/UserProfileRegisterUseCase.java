package com.sovliv.twitter.user.profile.usecase;

import com.sovliv.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {
    void registerUserProfile(UserProfileRegisterRequest request);
}
