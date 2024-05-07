package com.roba.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    OWNER_READ("owner:read"),
    OWNER_UPDATE("owner:update"),
    OWNER_CREATE("owner:create"),
    OWNER_DELETE("owner:delete");



    @Getter
    private final String permission;
}
