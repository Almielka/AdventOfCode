package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day08.Day08;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day08Test {

    private static final String DAY = "8";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-08-input-test.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-08-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day08();
    }

    @Test
    void testSolvePart1WithShortInput() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("5")));
    }

    @Test
    void testSolvePart1WithInputBig() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("1420")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("1420")));
    }

    @Test
    void testSolvePart2WithShortInput() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("8")));
    }

    @Test
    void testSolvePart2WithBigInput() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("1245")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("1245")));
    }

}