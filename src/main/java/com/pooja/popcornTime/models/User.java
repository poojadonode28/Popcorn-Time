package com.jatin.popcornTime.models;

import com.jatin.popcornTime.services.password.PasswordEncoder;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.Base64;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {

    private String username;
    private String email;
    private String hashedPassword;
    private String salt;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username) {
    }

    public void setPassword(String password, PasswordEncoder passwordEncoder) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must have at least 8 characters");
        }
        this.salt = generateSalt();
        this.hashedPassword = passwordEncoder.encode(password + salt);
    }

    public boolean checkPassword(String password, PasswordEncoder passwordEncoder) {
        String encoded = passwordEncoder.encode(password + salt);
        return encoded.equals(this.hashedPassword);
    }

    private String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] saltBytes = new byte[16];
        secureRandom.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}