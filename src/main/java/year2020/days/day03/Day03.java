package year2020.days.day03;

import year2020.days.AbstractDay;

import java.util.List;

/**
 * @author Anna S. Almielka
 * 08.12.2020
 */

public class Day03 extends AbstractDay {

    private static final int DAY = 3;

    public Day03() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(countTreesInForest(getListOfStringFromInput(DAY), 3, 1));
    }

    @Override
    public String solvePart2() {
        List<String> forest = getListOfStringFromInput(DAY);
        int countAll = countTreesInForest(forest, 1, 1);
        countAll *= countTreesInForest(forest, 3, 1);
        countAll *= countTreesInForest(forest, 5, 1);
        countAll *= countTreesInForest(forest, 7, 1);
        countAll *= countTreesInForest(forest, 1, 2);
        return String.valueOf(countAll);
    }

    private int countTreesInForest(List<String> forest, int coordinateX, int coordinateY) {
        int countTree = 0;
        for (int i = coordinateY, z = coordinateX; i < forest.size(); i += coordinateY, z += coordinateX) {
            StringBuilder line = new StringBuilder(forest.get(i));
            while (line.length() < z + 1) {
                line.append(line);
            }
            if (line.charAt(z) == 35) {
                countTree++;
            }
        }
        return countTree;
    }

}