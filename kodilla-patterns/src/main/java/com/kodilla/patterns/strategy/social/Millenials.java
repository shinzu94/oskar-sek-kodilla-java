package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;

public class Millenials extends User {
    public Millenials(String name) {
        super(name);
        this.preferredSocialPublisher = new FacebookPublisher();
    }
}
