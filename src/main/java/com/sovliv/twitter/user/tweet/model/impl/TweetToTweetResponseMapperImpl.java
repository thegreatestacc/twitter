package com.sovliv.twitter.user.tweet.model.impl;

import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.model.TweetToTweetResponseMapper;
import com.sovliv.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {
    @Override
    public TweetResponse map(Tweet model) {
        return new TweetResponse(
                model.getId(),
                model.getMessage(),
                model.getCreatedTimestamp()
        );
    }
}
