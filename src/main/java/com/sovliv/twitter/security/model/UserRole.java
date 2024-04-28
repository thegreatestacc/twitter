package com.sovliv.twitter.security.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table(schema = "identity", name = "user_roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String authority;
}
