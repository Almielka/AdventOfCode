package year2020.days;

import java.util.List;
/**
 * @author Anna S. Almielka
 * 08.12.2020
 */

/**
 * Due to the local geology, trees in this area only grow on exact integer coordinates in a grid.
 * You make a map (your puzzle input) of the open squares (.) and trees (#) you can see. For example:
 * <p>
 * ..##.......
 * #...#...#..
 * .#....#..#.
 * ..#.#...#.#
 * .#...##..#.
 * ..#.##.....
 * .#.#.#....#
 * .#........#
 * #.##...#...
 * #...##....#
 * .#..#...#.#
 * These aren't the only trees, though; due to something you read about once involving arboreal
 * genetics and biome stability, the same pattern repeats to the right many times:
 * <p>
 * ..##.........##.........##.........##.........##.........##.......  --->
 * #...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
 * .#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
 * ..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
 * .#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
 * ..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....  --->
 * .#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
 * .#........#.#........#.#........#.#........#.#........#.#........#
 * #.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...
 * #...##....##...##....##...##....##...##....##...##....##...##....#
 * .#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
 * You start on the open square (.) in the top-left corner and
 * need to reach the bottom (below the bottom-most row on your map).
 * <p>
 * The toboggan can only follow a few specific slopes
 * (you opted for a cheaper model that prefers rational numbers);
 * start by counting all the trees you would encounter for the slope right 3, down 1:
 * <p>
 * From your starting position at the top-left, check the position that is right 3 and down 1.
 * Then, check the position that is right 3 and down 1 from there,
 * and so on until you go past the bottom of the map.
 * <p>
 * The locations you'd check in the above example are marked here
 * with O where there was an open square and X where there was a tree:
 * <p>
 * ..##.........##.........##.........##.........##.........##.......  --->
 * #..O#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
 * .#....X..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
 * ..#.#...#O#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
 * .#...##..#..X...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
 * ..#.##.......#.X#.......#.##.......#.##.......#.##.......#.##.....  --->
 * .#.#.#....#.#.#.#.O..#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
 * .#........#.#........X.#........#.#........#.#........#.#........#
 * #.##...#...#.##...#...#.X#...#...#.##...#...#.##...#...#.##...#...
 * #...##....##...##....##...#X....##...##....##...##....##...##....#
 * .#..#...#.#.#..#...#.#.#..#...X.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
 * In this example, traversing the map using this slope would cause you to encounter 7 trees.
 * <p>
 * Starting at the top-left corner of your map and following a slope of right 3 and down 1,
 * how many trees would you encounter?
 * <p>
 * --- Part Two ---
 * Time to check the rest of the slopes - you need to minimize
 * the probability of a sudden arboreal stop, after all.
 * <p>
 * Determine the number of trees you would encounter if, for each of the following slopes,
 * you start at the top-left corner and traverse the map all the way to the bottom:
 * <p>
 * Right 1, down 1.
 * Right 3, down 1. (This is the slope you already checked.)
 * Right 5, down 1.
 * Right 7, down 1.
 * Right 1, down 2.
 * In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively;
 * multiplied together, these produce the answer 336.
 * <p>
 * What do you get if you multiply together the number of trees encountered on each of the listed slopes?
 */

public class Day03 extends AbstractDay {

    private static final int DAY = 3;

    public Day03() {
        super(DAY);
    }

    public int getDay() {
        return DAY;
    }

    @Override
    public String solvePart1() {
        return String.valueOf(countTreesInForest(getDataInputOfString(DAY), 3, 1));
    }

    @Override
    public String solvePart2() {
        List<String> forest = getDataInputOfString(DAY);
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