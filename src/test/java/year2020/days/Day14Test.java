package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day14.Day14;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day14Test {

    private static final String DAY = "14";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-14-input-test.txt";
    private static final String SHORT_INPUT2 = "src/test/resources/year2020/day-14-input-test-2.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-14-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day14();
    }

    @Test
    void testSolvePart1WithInputShort() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("165")));
    }

    @Test
    void testSolvePart1WithInputBig() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("9296748256641")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("9296748256641")));
    }

    @Test
    void testSolvePart2WithInputShort() {
        assertThat(day.solvePart2(SHORT_INPUT2), is(equalTo("208")));
    }

    @Test
    void testSolvePart2WithInputBig() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("4877695371685")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("4877695371685")));
    }
}