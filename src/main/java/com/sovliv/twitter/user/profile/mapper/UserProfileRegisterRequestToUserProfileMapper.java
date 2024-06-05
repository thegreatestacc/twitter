package com.sovliv.twitter.user.profile.mapper;

import com.sovliv.twitter.security.mapper.Mapper;
import com.sovliv.twitter.user.profile.UserProfile;
import com.sovliv.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterRequestToUserProfileMapper
        extends Mapper<UserProfile, UserProfileRegisterRequest> {
}
