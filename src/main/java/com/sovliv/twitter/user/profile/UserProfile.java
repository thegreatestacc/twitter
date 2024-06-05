package com.sovliv.twitter.user.profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(schema = "twitter", name = "user_profiles")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserProfile {
    @Id
    Long id;

    @Column(unique = true, nullable = false)
    String nickname;

    @Column(nullable = false)
    String imageLink;
}
