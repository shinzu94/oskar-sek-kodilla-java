package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<ForumUser> forumUserList = Forum.getUserList();
        Map<Integer, ForumUser> forumUserMap = forumUserList.stream()
                .filter(x -> x.getSex() == 'm')
                .filter(x -> ChronoUnit.YEARS.between(x.getBirthdate(), LocalDateTime.now()) >= 20)
                .filter(x -> x.getPostCounter() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, x -> x));

        forumUserMap.entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.println(forumUserMap);
    }
}