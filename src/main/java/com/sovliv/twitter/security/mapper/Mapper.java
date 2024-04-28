package com.sovliv.twitter.security.mapper;

public interface Mapper<D, S> {
    D map(S s);
}
