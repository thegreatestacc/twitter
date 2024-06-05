package com.sovliv.twitter.user.profile.reposotiry;

import com.sovliv.twitter.user.profile.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    boolean existsByNickname(String nickname);
}
