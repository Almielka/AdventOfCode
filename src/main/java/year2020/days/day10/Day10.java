package year2020.days.day10;

import year2020.days.AbstractDay2020;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anna S. Almielka
 * 17.12.2020
 */

public class Day10 extends AbstractDay2020 {

    private static final int DAY = 10;
    private static final int JOLT1 = 1;
    private static final int JOLT3 = 3;

    public Day10() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(findTwoNumbersThenMultiply(getListOfIntegerFromInput(DAY)));
    }

    @Override
    public String solvePart2() {
        return String.valueOf(countWays(getListOfIntegerFromInput(DAY)));
    }

    private List<Integer> correctingList(List<Integer> list) {
        Collections.sort(list);
        list.add(0, 0);
        list.add(list.get(list.size() - 1) + JOLT3);
        return list;
    }

    private int findTwoNumbersThenMultiply(List<Integer> list) {
        correctingList(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            int difference = list.get(i + 1) - list.get(i);
            map.merge(difference, 1, Integer::sum);
        }
        return map.get(JOLT1) * map.get(JOLT3);

    }


    private long countWays(List<Integer> list) {
        correctingList(list);
        long[] path = new long[list.size()];
        path[0] = 1;
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - JOLT3; j < i; j++) {
                if (j >= 0 && list.get(i) - list.get(j) <= JOLT3) {
                    path[i] += path[j];
                }
            }
        }
        return path[path.length - 1];
    }

}