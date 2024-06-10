package com.sovliv.twitter.user.tweet.repository;

import com.sovliv.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
