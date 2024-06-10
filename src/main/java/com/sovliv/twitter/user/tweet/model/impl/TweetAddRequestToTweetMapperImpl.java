package com.sovliv.twitter.user.tweet.model.impl;

import com.sovliv.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.model.TweetAddRequestToTweetMapper;
import com.sovliv.twitter.user.tweet.web.model.TweetAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Tweet map(TweetAddRequest request) {
        Tweet tweet = new Tweet();
        tweet.setUserProfile(this.currentUserProfileApiService.currentUserProfile());
        tweet.setMessage(request.message());
        return tweet;
    }
}
