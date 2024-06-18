package com.sovliv.twitter.user.profile.mapper;

import com.sovliv.twitter.security.mapper.Mapper;
import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.web.model.TweetEditRequest;

public interface TweetEditRequestToTweetMapper extends Mapper<Tweet, TweetEditRequest> {
}
