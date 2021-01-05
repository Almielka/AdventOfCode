package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day18.Day18;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day18Test {

    private static final String DAY = "18";
    private static final String SHORT_INPUT = "1 + 2 * 3 + 4 * 5 + 6";
    private static final String SHORT_INPUT2 = "1 + (2 * 3) + (4 * (5 + 6))";
    private static final String SHORT_INPUT3 = "2 * 3 + (4 * 5)";
    private static final String SHORT_INPUT4 = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
    private static final String SHORT_INPUT5 = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
    private static final String SHORT_INPUT6 = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day18();
    }

    @Test
    void testSolvePart1WithInputShort() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("71")));
    }

    @Test
    void testSolvePart1WithInputShort2() {
        assertThat(day.solvePart1(SHORT_INPUT2), is(equalTo("51")));
    }

    @Test
    void testSolvePart1WithInputShort3() {
        assertThat(day.solvePart1(SHORT_INPUT3), is(equalTo("26")));
    }

    @Test
    void testSolvePart1WithInputShort4() {
        assertThat(day.solvePart1(SHORT_INPUT4), is(equalTo("437")));
    }

    @Test
    void testSolvePart1WithInputShort5() {
        assertThat(day.solvePart1(SHORT_INPUT5), is(equalTo("12240")));
    }

    @Test
    void testSolvePart1WithInputShort6() {
        assertThat(day.solvePart1(SHORT_INPUT6), is(equalTo("13632")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("3885386961962")));
    }

    @Test
    void testSolvePart2WithInputShort() {
        assertThat(day.solvePart2(SHORT_INPUT), is(equalTo("231")));
    }

    @Test
    void testSolvePart2WithInputShort2() {
        assertThat(day.solvePart2(SHORT_INPUT2), is(equalTo("51")));
    }

    @Test
    void testSolvePart2WithInputShort3() {
        assertThat(day.solvePart2(SHORT_INPUT3), is(equalTo("46")));
    }

    @Test
    void testSolvePart2WithInputShort4() {
        assertThat(day.solvePart2(SHORT_INPUT4), is(equalTo("1445")));
    }

    @Test
    void testSolvePart2WithInputShort5() {
        assertThat(day.solvePart2(SHORT_INPUT5), is(equalTo("669060")));
    }

    @Test
    void testSolvePart2WithInputShort6() {
        assertThat(day.solvePart2(SHORT_INPUT6), is(equalTo("23340")));
    }

    @Test
    void testSolvePart2WithInputDay() {
        assertThat(day.solvePart2(DAY), is(equalTo("112899558798666")));
    }

}