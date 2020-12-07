package year2020.days;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

/**
 * The Elves in accounting just need you to fix your expense report (your puzzle input);
 * apparently, something isn't quite adding up.
 * <p>
 * Specifically, they need you to find the two entries that sum to 2020
 * and then multiply those two numbers together.
 * <p>
 * For example, suppose your expense report contained the following:
 * <p>
 * 1721
 * 979
 * 366
 * 299
 * 675
 * 1456
 * In this list, the two entries that sum to 2020 are 1721 and 299.
 * Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 * <p>
 * Of course, your expense report is much larger. Find the two entries that sum to 2020;
 * what do you get if you multiply them together?
 * <p>
 * --- Part Two ---
 * The Elves in accounting are thankful for your help;
 * one of them even offers you a starfish coin they had left over from a past vacation.
 * They offer you a second one if you can find three numbers in your expense report that meet the same criteria.
 * <p>
 * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
 * Multiplying them together produces the answer, 241861950.
 * <p>
 * In your expense report, what is the product of the three entries that sum to 2020?
 */

public class Day01 extends AbstractDay {

    private static final String INPUT = "src/main/resources/year2020/day-01-input.txt";
    private static final int SUM = 2020;
    private static final int DAY = 1;

    public Day01() {
        super(DAY);
    }

    @Override
    public int getDay(){
        return DAY;
    }

    @Override
    public void solvePart1() {
        findTwoNumbersThenMultiply(getDataInputOfInteger(INPUT), SUM).forEach(System.out::println);
    }

    @Override
    public void solvePart2() {
        findThreeNumbersThenMultiply(getDataInputOfInteger(INPUT), SUM).forEach(System.out::println);
    }

    private static List<Integer> findTwoNumbersThenMultiply(List<Integer> list, int value) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((list.get(i) + list.get(j)) == value) {
                    resultList.add(list.get(i) * list.get(j));
                }
            }

        }
        return resultList;
    }

    private static List<Integer> findThreeNumbersThenMultiply(List<Integer> list, int value) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.size() - 2; i++) {
            int tmp = value - list.get(i);
            List<Integer> tmpList = findTwoNumbersThenMultiply(list.subList(i + 1, list.size()), tmp);
            if (tmpList.size() != 0) {
                resultList.add(list.get(i) * tmpList.get(0));
            }
        }
        return resultList;
    }

}