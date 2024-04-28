package com.sovliv.twitter.security.service;

import com.sovliv.twitter.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
