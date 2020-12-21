package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day06.Day06;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day06Test {

    private static final String DAY = "6";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-06-input-test.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-06-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day06();
    }

    @Test
    void testSolvePart1WithShortInput() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("11")));
    }

    @Test
    void testSolvePart1WithBigInput() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("6443")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("6443")));
    }

    @Test
    void testSolvePart2WithShortInput() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("6")));
    }

    @Test
    void testSolvePart2WithBigInput() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("3232")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("3232")));
    }

}