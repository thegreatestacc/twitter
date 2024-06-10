package com.sovliv.twitter.user.profile.service;

import com.sovliv.twitter.user.profile.UserProfile;

import java.util.Optional;

public interface UserProfileService {

    void createUserProfile(UserProfile userProfile);

    Optional<UserProfile> findUserProfileById(long userProfileId);
}
