package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day11.Day11;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day11Test {

    private static final String DAY = "11";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-11-input-test.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-11-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day11();
    }

    @Test
    void testSolvePart1WithInputShort() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("37")));
    }

    @Test
    void testSolvePart1WithInputBig() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("2319")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("2319")));
    }

    @Test
    void testSolvePart2WithInputShort() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("26")));
    }

    @Test
    void testSolvePart2WithInputBig() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("2117")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("2117")));
    }

}