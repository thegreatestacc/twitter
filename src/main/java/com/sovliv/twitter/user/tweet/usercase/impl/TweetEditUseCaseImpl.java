package com.sovliv.twitter.user.tweet.usercase.impl;

import com.sovliv.twitter.user.profile.UserProfile;
import com.sovliv.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.sovliv.twitter.user.profile.mapper.TweetEditRequestToTweetMapper;
import com.sovliv.twitter.user.tweet.model.Tweet;
import com.sovliv.twitter.user.tweet.model.TweetToTweetResponseMapper;
import com.sovliv.twitter.user.tweet.service.TweetService;
import com.sovliv.twitter.user.tweet.usercase.TweetEditUseCase;
import com.sovliv.twitter.user.tweet.web.model.TweetEditRequest;
import com.sovliv.twitter.user.tweet.web.model.TweetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetEditUseCaseImpl implements TweetEditUseCase {

    private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public TweetResponse editTweet(TweetEditRequest editRequest) {
        UserProfile actor = this.currentUserProfileApiService.currentUserProfile();
        UserProfile tweetOwner = this.tweetService
                .findTweetById(editRequest.id())
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Tweet with id %d does not exist!", editRequest.id());
                    return new RuntimeException(errorMessage);
                });

        if (!actor.equals(tweetOwner)) {
            String errorMessage = String.format(
                    "Editing tweet with id %d forbidden! This user %s is not owner!",
                    editRequest.id(),
                    tweetOwner.getNickname()
            );
            throw new RuntimeException(errorMessage);
        }

        Tweet updatedTweet = this.tweetEditRequestToTweetMapper.map(editRequest);
        this.tweetService.updateTweet(updatedTweet);
        return this.tweetToTweetResponseMapper.map(updatedTweet);
    }
}
