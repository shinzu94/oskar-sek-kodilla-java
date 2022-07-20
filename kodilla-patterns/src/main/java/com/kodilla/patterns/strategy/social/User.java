package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class User {
    private final String name;
    @Setter
    protected SocialPublisher preferredSocialPublisher;

    public void sharePost() {
        preferredSocialPublisher.share();
    }
}
