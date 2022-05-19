package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    static int lastId = 0;
    private final int id;
    private final String userName;
    private final char sex;
    private final LocalDate birthdate;
    private final int postCounter;

    public ForumUser(String userName, char sex, LocalDate birthdate, int postCounter) {
        this.id = ++lastId;
        this.userName = userName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.postCounter = postCounter;
    }

    public int getId() {
        return id;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getPostCounter() {
        return postCounter;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", postCounter=" + postCounter +
                '}';
    }
}
