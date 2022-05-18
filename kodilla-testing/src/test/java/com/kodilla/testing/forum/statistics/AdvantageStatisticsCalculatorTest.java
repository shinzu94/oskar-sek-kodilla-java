package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AdvantageStatisticsCalculatorTest {
    private static final List<String> emptyListOfUserNames = new ArrayList<>();
    private static final List<String> listOf100UsersNames = new ArrayList<>();
    @Mock
    private Statistics statisticsMock;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 100; i++) {
            listOf100UsersNames.add("User " + i);
        }
    }

    @Test
    public void testCalculateStatisticsFor0Users() {
        //Given
        AdvantageStatisticsCalculator advantageStatisticsCalculator = new AdvantageStatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(emptyListOfUserNames);

        //When
        advantageStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        int resultPostCounts = advantageStatisticsCalculator.getPostsCount();
        int resultCommentsCounts = advantageStatisticsCalculator.getCommentsCount();
        int resultUsersCounts = advantageStatisticsCalculator.getUsersCount();
        double resultPostsPerUser = advantageStatisticsCalculator.getPostsPerUser();
        double resultCommentsPerPost = advantageStatisticsCalculator.getCommentsPerPost();
        double resultCommentsPerUser = advantageStatisticsCalculator.getCommentsPerUser();

        //Then
        assertEquals(0, resultPostCounts);
        assertEquals(0, resultCommentsCounts);
        assertEquals(0, resultUsersCounts);
        assertEquals(0, resultPostsPerUser);
        assertEquals(0, resultCommentsPerUser);
        assertEquals(0, resultCommentsPerPost);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/AdvantageStatisticsCalculatorFor0UsersShouldThrowExceptionTestCases.csv", delimiter = ':')
    public void testCalculateStatisticsFor0UsersShouldThrowIllegalArgumentException(int postsCount, int commentsCount) {
        //Given
        AdvantageStatisticsCalculator advantageStatisticsCalculator = new AdvantageStatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(emptyListOfUserNames);

        //Then
        assertThrows(IllegalArgumentException.class, () -> {
            advantageStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/AdvantageStatisticsCalculatorFor100UsersTestCases.csv", delimiter = ':')
    public void testCalculateStatisticsFor100Users(int postsCount, int commentsCount, double expectedPostPerUsers, double expectedCommentsPerUsers, double expectedCommentsPerPosts) {
        //Given
        AdvantageStatisticsCalculator advantageStatisticsCalculator = new AdvantageStatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOf100UsersNames);

        //When
        advantageStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        int resultPostCounts = advantageStatisticsCalculator.getPostsCount();
        int resultCommentsCounts = advantageStatisticsCalculator.getCommentsCount();
        int resultUsersCounts = advantageStatisticsCalculator.getUsersCount();
        double resultPostsPerUser = advantageStatisticsCalculator.getPostsPerUser();
        double resultCommentsPerPost = advantageStatisticsCalculator.getCommentsPerPost();
        double resultCommentsPerUser = advantageStatisticsCalculator.getCommentsPerUser();

        //Then
        assertEquals(postsCount, resultPostCounts);
        assertEquals(commentsCount, resultCommentsCounts);
        assertEquals(100, resultUsersCounts);
        assertEquals(expectedPostPerUsers, resultPostsPerUser);
        assertEquals(expectedCommentsPerUsers, resultCommentsPerUser);
        assertEquals(expectedCommentsPerPosts, resultCommentsPerPost);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/AdvantageStatisticsCalculatorFor100UsersShouldThrowExceptionTestCases.csv", delimiter = ':')
    public void testCalculateStatisticsFor100WithExceptionUsers(int postsCount, int commentsCount) {
        //Given
        AdvantageStatisticsCalculator advantageStatisticsCalculator = new AdvantageStatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(listOf100UsersNames);

        //Then
        assertThrows(IllegalArgumentException.class, () -> {
            advantageStatisticsCalculator.calculateAdvStatistics(statisticsMock);
        });
    }
}
