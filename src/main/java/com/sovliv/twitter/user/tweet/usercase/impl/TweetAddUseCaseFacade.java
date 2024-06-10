package com.sovliv.twitter.user.tweet.usercase.impl;

import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.model.TweetAddRequestToTweetMapper;
import com.sovliv.twitter.user.tweet.model.TweetToTweetResponseMapper;
import com.sovliv.twitter.user.tweet.service.TweetService;
import com.sovliv.twitter.user.tweet.usercase.TweetAddUseCase;
import com.sovliv.twitter.user.tweet.web.model.TweetAddRequest;
import com.sovliv.twitter.user.tweet.web.model.TweetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetAddUseCaseFacade implements TweetAddUseCase {

    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    @Override
    public TweetResponse addTweet(TweetAddRequest addRequest) {
        Tweet mappedTweet = this.tweetAddRequestToTweetMapper.map(addRequest);
        Tweet createdTweet = this.tweetService.createTweet(mappedTweet);
        return this.tweetToTweetResponseMapper.map(createdTweet);
    }
}
