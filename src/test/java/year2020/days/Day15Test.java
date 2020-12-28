package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day15.Day15;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day15Test {

    private static final String DAY = "15";
    private static final String SHORT_INPUT = "0,3,6";
    private static final String SHORT_INPUT2 = "1,3,2";
    private static final String SHORT_INPUT3 = "2,1,3";
    private static final String SHORT_INPUT4 = "1,2,3";
    private static final String SHORT_INPUT5 = "2,3,1";
    private static final String SHORT_INPUT6 = "3,2,1";
    private static final String SHORT_INPUT7 = "3,1,2";
    private static final String BIG_INPUT = "0,14,1,3,7,9";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day15();
    }

    @Test
    void testSolvePart1WithInputShort() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("436")));
    }

    @Test
    void testSolvePart1WithInputShort2() {
        assertThat(day.solvePart1(SHORT_INPUT2), is(equalTo("1")));
    }

    @Test
    void testSolvePart1WithInputShort3() {
        assertThat(day.solvePart1(SHORT_INPUT3), is(equalTo("10")));
    }

    @Test
    void testSolvePart1WithInputShort4() {
        assertThat(day.solvePart1(SHORT_INPUT4), is(equalTo("27")));
    }

    @Test
    void testSolvePart1WithInputShort5() {
        assertThat(day.solvePart1(SHORT_INPUT5), is(equalTo("78")));
    }

    @Test
    void testSolvePart1WithInputShort6() {
        assertThat(day.solvePart1(SHORT_INPUT6), is(equalTo("438")));
    }

    @Test
    void testSolvePart1WithInputShort7() {
        assertThat(day.solvePart1(SHORT_INPUT7), is(equalTo("1836")));
    }

    @Test
    void testSolvePart1WithInputBig() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("763")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("763")));
    }

    @Test
    void testSolvePart2WithInputShort() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("175594")));
    }

    @Test
    void testSolvePart2WithInputShort2() {
        assertThat(day.solvePart2(SHORT_INPUT2), is(equalTo("2578")));
    }

    @Test
    void testSolvePart2WithInputShort3() {
        assertThat(day.solvePart2(SHORT_INPUT3), is(equalTo("3544142")));
    }

    @Test
    void testSolvePart2WithInputShort4() {
        assertThat(day.solvePart2(SHORT_INPUT4), is(equalTo("261214")));
    }

    @Test
    void testSolvePart2WithInputShort5() {
        assertThat(day.solvePart2(SHORT_INPUT5), is(equalTo("6895259")));
    }

    @Test
    void testSolvePart2WithInputShort6() {
        assertThat(day.solvePart2(SHORT_INPUT6), is(equalTo("18")));
    }

    @Test
    void testSolvePart2WithInputShort7() {
        assertThat(day.solvePart2(SHORT_INPUT7), is(equalTo("362")));
    }

    @Test
    void testSolvePart2WithInputBig() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("1876406")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("1876406")));
    }

}