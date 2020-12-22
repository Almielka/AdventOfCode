package year2020.days.day13;

import year2020.days.AbstractDay2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 21.12.2020
 */

public class Day13 extends AbstractDay2020 {

    private static final int DAY = 13;

    public Day13() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(getIDThenMultiply(parseStringToList(getStringFromInput(puzzleInput))));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return String.valueOf("0");
    }

    private List<Integer> parseStringToList(String str) {
        String[] arr = str.split("\r\n");
        List<Integer> timestamps = Arrays.stream(arr[1].split(","))
                .filter(s -> !s.equals("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        timestamps.add(0, Integer.parseInt(arr[0]));
        return timestamps;
    }

    private int getIDThenMultiply(List<Integer> timestamps) {
        int myTime = timestamps.get(0);
        int minTimeID = timestamps.stream()
                //59 fits 15 times in 939 and remainder 54 it's the minimum remainder among all ids
                .min(Comparator.comparingInt(id -> id - (myTime % id)))
                .get();
        return minTimeID * (minTimeID - (myTime % minTimeID));
    }

}