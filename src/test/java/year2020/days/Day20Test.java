package year2020.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import year2020.days.day20.Day20;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class Day20Test {

    private static final String DAY = "20";
    private static final String SHORT_INPUT = "src/test/resources/year2020/day-20-input-test.txt";
    private static final String BIG_INPUT = "src/main/resources/year2020/day-20-input.txt";
    private AbstractDay2020 day;

    @BeforeEach
    void setUp() {
        day = new Day20();
    }

    @Test
    void testSolvePart1WithInputShort() {
        assertThat(day.solvePart1(SHORT_INPUT), is(equalTo("20899048083289")));
    }

    @Test
    void testSolvePart1WithInputBig() {
        assertThat(day.solvePart1(BIG_INPUT), is(equalTo("111936085519519")));
    }

    @Test
    void testSolvePart1WithInputDay() {
        assertThat(day.solvePart1(DAY), is(equalTo("111936085519519")));
    }

}