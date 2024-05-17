package com.roba.security.auth;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class Emailvalidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return false;
    }
}
