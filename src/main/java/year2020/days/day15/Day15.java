package year2020.days.day15;

import year2020.days.AbstractDay2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 28.12.2020
 */

public class Day15 extends AbstractDay2020 {

    private static final int DAY = 15;

    public Day15() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(memoryGame(parseStringToList(puzzleInput), 2020));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return String.valueOf(memoryGame(parseStringToList(puzzleInput), 30000000));
    }

    private List<Integer> parseStringToList(String puzzleInput) {
        if (puzzleInput.equals(String.valueOf(DAY))) {
            puzzleInput = getStringFromInput(puzzleInput);
        }
        String[] arr = puzzleInput.split(",");
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int memoryGame(List<Integer> list, int max) {
        int turn = list.size() - 1;
        Map<Integer, Integer> vanEckMap = new HashMap<>();
        for (int i = 0; i < turn; i++) {
            vanEckMap.put(list.get(i), i);
        }
        int currentNumber = list.get(turn);
        for (int i = turn; i < max - 1; i++) {
            int vanEck = vanEckMap.containsKey(currentNumber) ? i - vanEckMap.get(currentNumber) : 0;
            vanEckMap.put(currentNumber, i);
            currentNumber = vanEck;
        }
        return currentNumber;
    }

}