package com.sovliv.twitter.security.mapper;

import com.sovliv.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount>{
}
