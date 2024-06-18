package com.sovliv.twitter.user.tweet.usercase;

import com.sovliv.twitter.user.tweet.web.model.TweetEditRequest;
import com.sovliv.twitter.user.tweet.web.model.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest editRequest);
}
