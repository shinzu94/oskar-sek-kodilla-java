package com.kodilla.kodillaspring.forum;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ForumUser {
    private final String username;

    public ForumUser() {
        this.username = "John Smith";
    }
}