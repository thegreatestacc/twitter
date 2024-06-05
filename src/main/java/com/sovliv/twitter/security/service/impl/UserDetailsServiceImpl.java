package com.sovliv.twitter.security.service.impl;

import com.sovliv.twitter.security.mapper.UserAccountToUserMapper;
import com.sovliv.twitter.security.service.UserAccountService;
import com.sovliv.twitter.security.web.exceptions.CustomUsernameNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;
    private final UserAccountToUserMapper userAccountToUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userAccountService
                .findUserByUsername(username)
                .map(userAccountToUserMapper::map)
                .orElseThrow(() -> new CustomUsernameNotFoundException(username));
    }
}
