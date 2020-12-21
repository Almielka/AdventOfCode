package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day04.Day04;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day04Test {

    private static final String DAY = "4";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-04-input-test.txt";
    private static final String SHORT_INPUT2 = "src/test/resources/year2020/day-04-input-test-2.txt";
    private static final String SHORT_INPUT3 = "src/test/resources/year2020/day-04-input-test-3.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-04-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day04();
    }

    @Test
    void testSolvePart1WithShortInput() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("2")));
    }

    @Test
    void testSolvePart1WithBigInput() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("239")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("239")));
    }

    @Test
    void testSolvePart2WithShortInput() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("2")));
    }

    @Test
    void testSolvePart2WithShortInput2() {
        assertThat(day.solvePart2(SHORT_INPUT2), is(equalTo("0")));
    }

    @Test
    void testSolvePart2WithShortInput3() {
        assertThat(day.solvePart2(SHORT_INPUT3), is(equalTo("4")));
    }

    @Test
    void testSolvePart2WithBigInput() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("188")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("188")));
    }

}