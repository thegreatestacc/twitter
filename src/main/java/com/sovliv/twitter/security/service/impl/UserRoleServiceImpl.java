package com.sovliv.twitter.security.service.impl;

import com.sovliv.twitter.security.model.UserRole;
import com.sovliv.twitter.security.repository.UserRoleRepository;
import com.sovliv.twitter.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findUserRole() {
        return this.userRoleRepository.findByAuthority("ROLE_USER");
    }
}
