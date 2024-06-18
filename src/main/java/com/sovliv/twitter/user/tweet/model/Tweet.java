package com.sovliv.twitter.user.tweet.model;

import com.sovliv.twitter.user.profile.UserProfile;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(schema = "twitter", name = "tweets")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String message;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    Instant createdTimestamp;

    @LastModifiedDate
    @Column(nullable = false)
    Instant modifiedTimestamp;

    @ManyToOne(optional = false)
    UserProfile userProfile;
}
