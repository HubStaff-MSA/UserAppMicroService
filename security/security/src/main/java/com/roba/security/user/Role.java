package com.roba.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.roba.security.user.Permission.*;


@RequiredArgsConstructor

public enum Role {
    USER(Collections.emptySet()),

    OWNER(Set.of(OWNER_READ,
            OWNER_UPDATE,
            OWNER_DELETE,
            OWNER_CREATE)),
    BUSINESS_MANAGER(Collections.emptySet()),
    PROJECT_MANAGER(Collections.emptySet());

@Getter
private final Set<Permission> permissions;
public List<SimpleGrantedAuthority> getAuthorities(){
    var authorities=getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.name()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE"+this.name()));
    return authorities;
    }
}
