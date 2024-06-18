package com.sovliv.twitter.user.profile.mapper.impl;

import com.sovliv.twitter.user.profile.mapper.TweetEditRequestToTweetMapper;
import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.service.TweetService;
import com.sovliv.twitter.user.tweet.web.model.TweetEditRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {

    private final TweetService tweetService;

    @Override
    public Tweet map(TweetEditRequest editRequest) {
        Tweet currentTweet = this.tweetService
                .findTweetById(editRequest.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Tweet with id %d does not exist!", editRequest.id());
                    return new RuntimeException(errorMessage);
                });
        currentTweet.setMessage(editRequest.message());
        return currentTweet;
    }
}
