package com.sovliv.twitter.user.profile.api.service.impl;

import com.sovliv.twitter.security.api.model.CurrentUserApiModel;
import com.sovliv.twitter.security.api.service.IdentityApiService;
import com.sovliv.twitter.user.profile.UserProfile;
import com.sovliv.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.sovliv.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {

    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    @Override
    public UserProfile currentUserProfile() {
        CurrentUserApiModel currentUserApiModel = this.identityApiService.currentUserAccount()
                .orElseThrow(() -> new RuntimeException("User must be authorized in system!"));

        return this.userProfileService.findUserProfileById(currentUserApiModel.userAccountId())
                .orElseThrow(() -> {
                    String errorMessage = String.format("User profile with id %d doesn't exist!",
                            currentUserApiModel.userAccountId());
                    return new RuntimeException(errorMessage);
                });
    }
}
