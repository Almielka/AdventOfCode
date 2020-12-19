package year2020.days.day09;

import year2020.days.AbstractDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anna S. Almielka
 * 15.12.2020
 */

public class Day09 extends AbstractDay {

    private static final int DAY = 9;
    private static final int PREAMBLE = 25;

    public Day09() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(findNumber(getListOfLongFromInput(DAY)));
    }

    @Override
    public String solvePart2() {
        long numberFromPart1 = findNumber(getListOfLongFromInput(DAY));
        return String.valueOf(findTwoNumbersThenAdd(getListOfLongFromInput(DAY), numberFromPart1));
    }

    private long findNumber(List<Long> list) {
        long number = 0;
        for (int i = PREAMBLE; i < list.size(); i++) {
            number = list.get(i);
            List<Long> tmpList = new ArrayList<>();
            long result = 0;

            for (int j = i - PREAMBLE; j < list.size() - 1; j++) {
                long tmpLong = number - list.get(j);
                if (tmpList.contains(tmpLong)) {
                    result = number;
                }
                tmpList.add(list.get(j));
            }
            if (result == 0) break;
        }
        return number;
    }

    private long findTwoNumbersThenAdd(List<Long> list, long numberFromPart1) {
        long result = 0;
        for (int i = 0; i < list.indexOf(numberFromPart1); i++) {
            long tmpLong = list.get(i);
            List<Long> tmpList = new ArrayList<>();
            tmpList.add(list.get(i));
            int tmpIndex = i;

            while (tmpLong < numberFromPart1) {
                tmpIndex++;
                tmpLong += list.get(tmpIndex);
                tmpList.add(list.get(tmpIndex));
            }
            if (tmpLong == numberFromPart1) {
                Collections.sort(tmpList);
                result = tmpList.get(0) + tmpList.get(tmpList.size() - 1);
            }
        }
        return result;
    }

}