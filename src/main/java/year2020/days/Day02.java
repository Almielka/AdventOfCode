package year2020.days;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */


/**
 * For example, suppose you have the following list:
 * <p>
 * 1-3 a: abcde
 * 1-3 b: cdefg
 * 2-9 c: ccccccccc
 * Each line gives the password policy and then the password.
 * The password policy indicates the lowest and highest number of times
 * a given letter must appear for the password to be valid. For example
 * 1-3 a means that the password must contain a at least 1 time and at most 3 times.
 * <p>
 * In the above example, 2 passwords are valid. The middle password, cdefg, is not;
 * it contains no instances of b, but needs at least 1.
 * The first and third passwords are valid: they contain one a or nine c,
 * both within the limits of their respective policies.
 * <p>
 * How many passwords are valid according to their policies?
 * <p>
 * --- Part Two ---
 * While it appears you validated the passwords correctly,
 * they don't seem to be what the Official Toboggan Corporate Authentication System is expecting.
 * <p>
 * The shopkeeper suddenly realizes that he just accidentally explained the password policy rules
 * from his old job at the sled rental place down the street!
 * The Official Toboggan Corporate Policy actually works a little differently.
 * <p>
 * Each policy actually describes two positions in the password, where 1 means the first character,
 * 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!)
 * Exactly one of these positions must contain the given letter.
 * Other occurrences of the letter are irrelevant for the purposes of policy enforcement.
 * <p>
 * Given the same example list from above:
 * <p>
 * 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
 * 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
 * 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
 * How many passwords are valid according to the new interpretation of the policies?
 */

public class Day02 extends AbstractDay {

    private static final int DAY = 2;

    public Day02() {
        super(DAY);
    }

    public int getDay() {
        return DAY;
    }

    @Override
    public String solvePart1() {
        return String.valueOf(getDataInputOfString(DAY).stream().
                filter(line -> isValidPart1(parseString(line))).count());
    }

    @Override
    public String solvePart2() {
        return String.valueOf(getDataInputOfString(DAY).stream().
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
