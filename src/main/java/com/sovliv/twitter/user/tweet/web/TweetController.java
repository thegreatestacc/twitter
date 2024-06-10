package com.sovliv.twitter.user.tweet.web;

import com.sovliv.twitter.user.tweet.usercase.TweetAddUseCase;
import com.sovliv.twitter.user.tweet.web.model.TweetAddRequest;
import com.sovliv.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest addRequest) {
        return this.tweetAddUseCase.addTweet(addRequest);
    }
}
