package com.sovliv.twitter.user.tweet.web.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetEditRequest(
        @NotNull
        long id,
        @NotNull
        @Size(min = 5, max = 180)
        String message) {
}
