package com.sovliv.twitter.user.tweet.web;

import com.sovliv.twitter.user.tweet.usercase.TweetAddUseCase;
import com.sovliv.twitter.user.tweet.usercase.TweetEditUseCase;
import com.sovliv.twitter.user.tweet.web.model.TweetAddRequest;
import com.sovliv.twitter.user.tweet.web.model.TweetEditRequest;
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
    private final TweetEditUseCase tweetEditUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest addRequest) {
        return this.tweetAddUseCase.addTweet(addRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TweetResponse updateTweet(@Valid @RequestBody TweetEditRequest editRequest) {
        return this.tweetEditUseCase.editTweet(editRequest);
    }
}
