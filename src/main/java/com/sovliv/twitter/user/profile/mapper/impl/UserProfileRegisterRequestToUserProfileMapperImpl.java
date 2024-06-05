package com.sovliv.twitter.user.profile.mapper.impl;

import com.sovliv.twitter.security.api.model.CurrentUserApiModel;
import com.sovliv.twitter.security.api.service.IdentityApiService;
import com.sovliv.twitter.user.profile.UserProfile;
import com.sovliv.twitter.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.sovliv.twitter.user.profile.web.model.UserProfileRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRegisterRequestToUserProfileMapperImpl implements UserProfileRegisterRequestToUserProfileMapper {

    private final IdentityApiService identityApiService;

    @Override
    public UserProfile map(UserProfileRegisterRequest request) {

        CurrentUserApiModel currentUserApiModel = this.identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new RuntimeException("For profile creation user must be authorized in system."));

        UserProfile userProfile = new UserProfile();
        userProfile.setId(currentUserApiModel.userAccountId());
        userProfile.setNickname(request.nickname());
        userProfile.setImageLink(request.imageLink());
        return userProfile;
    }
}
