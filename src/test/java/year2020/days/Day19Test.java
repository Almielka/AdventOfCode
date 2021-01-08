package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day19.Day19;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day19Test {

    private static final String DAY = "19";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-19-input-test.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-19-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day19();
    }

    @Test
    void testSolvePart1WithInputShort() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("2")));
    }

    @Test
    void testSolvePart1WithInputBig() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("122")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("122")));
    }

}