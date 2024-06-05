package com.sovliv.twitter.user.profile.service.impl;

import com.sovliv.twitter.user.profile.UserProfile;
import com.sovliv.twitter.user.profile.reposotiry.UserProfileRepository;
import com.sovliv.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public void createUserProfile(UserProfile userProfile) {

        if (this.userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = String.format(
                    "User profile with id %d already exist!", userProfile.getId());
            throw new RuntimeException(errorMessage);
        }

        if (this.userProfileRepository.existsByNickname(userProfile.getNickname())) {
            String errorMessage = String.format(
                    "User profile with nickname %s already exist!", userProfile.getId());
            throw new RuntimeException(errorMessage);
        }
        this.userProfileRepository.save(userProfile);
    }
}
