package year2020.days.day01;

import year2020.days.AbstractDay2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public class Day01 extends AbstractDay2020 {

    private static final int SUM = 2020;
    private static final int DAY = 1;

    public Day01() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(findTwoNumbersThenMultiply(getListOfIntegerFromInput(DAY), SUM));
    }

    @Override
    public String solvePart2() {
        return String.valueOf(findThreeNumbersThenMultiply(getListOfIntegerFromInput(DAY), SUM));
    }

    private int findTwoNumbersThenMultiply(List<Integer> list, int value) {
        List<Integer> tmpList = new ArrayList<>();
        int result = 0;
        for (Integer i : list) {
            int tmpInt = value - i;
            if (tmpList.contains(tmpInt)) {
                result = i * tmpInt;
            }
            tmpList.add(i);
        }
        return result;
    }

    private int findThreeNumbersThenMultiply(List<Integer> list, int value) {
        int result = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            int tmp = value - list.get(i);
            int resultTwoNumbers = findTwoNumbersThenMultiply(list.subList(i + 1, list.size()), tmp);
            if (resultTwoNumbers != 0) {
                result = list.get(i) * resultTwoNumbers;
            }
        }
        return result;
    }

}