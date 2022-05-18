package com.kodilla.testing.forum.statistics;

public class AdvantageStatisticsCalculator {
    private int postsCount;
    private int usersCount;
    private int commentsCount;
    private double postsPerUser;
    private double commentsPerPost;
    private double commentsPerUser;

    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics.postsCount() < 0 || statistics.commentsCount() < 0) {
            throw new IllegalArgumentException("Posts and comments count can't be negative.");
        }
        if (statistics.usersNames().size() == 0 && (statistics.postsCount() > 0 || statistics.commentsCount() > 0)) {
            throw new IllegalArgumentException("When users don't exist, posts and comments count can't be more than Zero.");
        }
        if (statistics.postsCount() == 0 && statistics.commentsCount() > 0) {
            throw new IllegalArgumentException("When the posts count is zero, the comments count can't be more than Zero.");
        }
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        usersCount = statistics.usersNames().size();
        if (usersCount > 0) {
            postsPerUser = ((double) postsCount) / usersCount;
            commentsPerUser = ((double) commentsCount) / usersCount;
        }
        if (postsCount > 0) {
            commentsPerPost = ((double) commentsCount) / postsCount;
        }
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
