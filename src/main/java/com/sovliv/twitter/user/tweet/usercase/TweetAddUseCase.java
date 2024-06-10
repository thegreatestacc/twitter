package com.sovliv.twitter.user.tweet.usercase;

import com.sovliv.twitter.user.tweet.web.model.TweetAddRequest;
import com.sovliv.twitter.user.tweet.web.model.TweetResponse;

public interface TweetAddUseCase {
    TweetResponse addTweet(TweetAddRequest addRequest);
}
