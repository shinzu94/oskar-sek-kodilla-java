package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    public static List<ForumUser> getUserList() {
        final List<ForumUser> list = new ArrayList<>();

        list.add(new ForumUser("Tomasz Nowak",
                'm',
                LocalDate.of(1991, 11, 10),
                4));

        list.add(new ForumUser("Kamil Jabłońki",
                'm',
                LocalDate.of(1993, 3, 15),
                4));

        list.add(new ForumUser("Wiktoria Goździkowa",
                'w',
                LocalDate.of(1973, 5, 21),
                20));

        return new ArrayList<>(list);
    }
}
