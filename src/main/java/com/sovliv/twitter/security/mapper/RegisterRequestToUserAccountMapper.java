package com.sovliv.twitter.security.mapper;

import com.sovliv.twitter.security.model.UserAccount;
import com.sovliv.twitter.security.web.model.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper <UserAccount, RegisterRequest> {
}
