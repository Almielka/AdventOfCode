package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day02.Day02;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day02Test {

    private static final String DAY = "2";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-02-input-test.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-02-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day02();
    }

    @Test
    void testSolvePart1WithShortInput() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("2")));
    }

    @Test
    void testSolvePart1WithBigInput() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("625")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("625")));
    }

    @Test
    void testSolvePart2WithShortInput() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("1")));
    }

    @Test
    void testSolvePart2WithBigInput() {
        assertThat(day.solvePart2(BIG_INPUT), is(equalTo("391")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("391")));
    }

}