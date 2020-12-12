package year2020.days.day02;
import year2020.days.AbstractDay;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public class Day02 extends AbstractDay {

    private static final int DAY = 2;

    public Day02() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(getListOfStringFromInput(DAY).stream().
                filter(line -> isValidPart1(parseString(line))).count());
    }

    @Override
    public String solvePart2() {
        return String.valueOf(getListOfStringFromInput(DAY).stream().
                filter(line -> isValidPart2(parseString(line))).count());
    }

    private String[] parseString(String str) {
        String[] arrParts = str.split(" ");
        String[] arrRules = arrParts[0].split("-");
        return new String[]{arrRules[0], arrRules[1], String.valueOf(arrParts[1].charAt(0)), arrParts[2]};
    }

    private boolean isValidPart1(String[] arr) {
        long countLetter = arr[3].chars().filter(v -> v == arr[2].charAt(0)).count();
        return countLetter >= Integer.parseInt(arr[0]) && countLetter <= Integer.parseInt(arr[1]);
    }

    private boolean isValidPart2(String[] arr) {
        char letter = arr[2].charAt(0);
        char[] arrPassword = arr[3].toCharArray();
        char char1 = arrPassword[Integer.parseInt(arr[0]) - 1];
        char char2 = arrPassword[Integer.parseInt(arr[1]) - 1];
        return char1 != char2 && (char1 == letter || char2 == letter);
    }

}
