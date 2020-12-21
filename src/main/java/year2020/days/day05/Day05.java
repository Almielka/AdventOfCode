package year2020.days.day05;

import year2020.days.AbstractDay2020;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Anna S. Almielka
 * 10.12.2020
 */

public class Day05 extends AbstractDay2020 {

    private static final int DAY = 5;
    private static final char F = 70;
    private static final char B = 66;
    private static final char L = 76;
    private static final char R = 82;

    public Day05() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(Collections.max(getIds(puzzleInput)));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        List<Integer> ids = getIds(puzzleInput);
        Set<Integer> missedIds = IntStream.rangeClosed(Collections.min(ids), Collections.max(ids)).boxed().collect(Collectors.toSet());
        missedIds.removeAll(ids);
        return String.valueOf(missedIds.stream().findFirst().orElse(-1));
    }

    private int parseString(String str) {
        int rowStart = 0;
        int rowEnd = 127;
        int columnStart = 0;
        int columnEnd = 7;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == F) {
                rowEnd = (rowEnd + rowStart) / 2;
            } else if (str.charAt(i) == B) {
                rowStart = (rowEnd + rowStart + 2) / 2;
            } else if (str.charAt(i) == L) {
                columnEnd = (columnEnd + columnStart) / 2;
            } else if (str.charAt(i) == R) {
                columnStart = (columnEnd + columnStart + 2) / 2;
            }
        }
        return rowEnd * 8 + columnEnd;
    }

    private List<Integer> getIds(String puzzleInput) {
        return getListOfStringFromInput(puzzleInput).stream()
                .map(this::parseString).collect(Collectors.toList());
    }

}