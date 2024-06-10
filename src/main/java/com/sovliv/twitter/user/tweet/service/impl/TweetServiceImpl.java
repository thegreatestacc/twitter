package com.sovliv.twitter.user.tweet.service.impl;

import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.repository.TweetRepository;
import com.sovliv.twitter.user.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    @Override
    public Tweet createTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }
}
