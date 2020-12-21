package year2020.days.day06;

import year2020.days.AbstractDay2020;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Anna S. Almielka
 * 11.12.2020
 */

public class Day06 extends AbstractDay2020 {

    private static final int DAY = 6;

    public Day06() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(Arrays.stream(getStringFromInput(puzzleInput)
                .split("\r\n\r\n"))
                .map(v -> v.replace("\r\n", ""))
                .mapToLong(v -> v.chars().distinct().count())
                .sum());
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return String.valueOf(parseStringToStream(getStringFromInput(puzzleInput))
                .mapToInt(this::parseGroup).sum());
    }

    private Stream<String> parseStringToStream(String str) {
        String[] arr = str.split("\r\n\r\n");
        return Arrays.stream(arr);
    }

    private int parseGroup(String s) {
        String[] arr = s.split("\r\n");
        Set<Integer> setFirstChars = arr[0].chars().boxed().collect(Collectors.toSet());

        for (String str : arr) {
            setFirstChars.retainAll(str.chars().boxed().collect(Collectors.toSet()));
        }

        return setFirstChars.size();
    }

}
