package com.sovliv.twitter.security.api.service;

import com.sovliv.twitter.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
