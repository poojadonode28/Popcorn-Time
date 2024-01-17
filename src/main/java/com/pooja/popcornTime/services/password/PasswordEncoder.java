package com.jatin.popcornTime.services.password;

public interface PasswordEncoder {
    String encode(String plainText);
}