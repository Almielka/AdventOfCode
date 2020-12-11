package year2020.days.day04;

import year2020.days.AbstractDay;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Anna S. Almielka
 * 10.12.2020
 */

public class Day04 extends AbstractDay {

    private static final int DAY = 4;

    private static final Map<String, String> mandatoryFields = Map.of(
            "byr", "^(19[2-9][0-9]|200[0-2])$",
            "iyr", "^(201[0-9]|2020)$",
            "eyr", "^(202[0-9]|2030)$",
            "hgt", "^((1[5-8][0-9]|19[0-3])cm)|((59|6[0-9]|7[0-6])in)$",
            "hcl", "^(#[0-9a-f]{6})$",
            "ecl", "^(amb|blu|brn|gry|grn|hzl|oth)$",
            "pid", "^([0-9]{9})$"
    );

    public Day04() {
        super(DAY);
    }

    @Override
    public int getDay() {
        return DAY;
    }

    @Override
    public String solvePart1() {
        return String.valueOf(
                parseStringToStream(getStringFromInput(DAY))
                        .filter(Passport::isValidPart1)
                        .count());
    }

    @Override
    public String solvePart2() {
        return String.valueOf(
                parseStringToStream(getStringFromInput(DAY))
                        .filter(Passport::isValidPart2)
                        .count());
    }

    private Stream<Passport> parseStringToStream(String getData) {
        String[] arr = getData.split("\r\n\r\n");
        return Arrays.stream(arr).map(Passport::new);
    }

    private static class Passport {

        String[] fields;

        public Passport(String str) {
            fields = str.replace("\r\n", " ").split(" ");
        }

        private boolean isValidPart1() {
            return Arrays.stream(fields)
                    .map(s -> s.substring(0, 3))
                    .collect(Collectors.toSet())
                    .containsAll(mandatoryFields.keySet());
        }

        private boolean isValidPart2() {
            return isValidPart1() &&
                    Arrays.stream(fields)
                            .map(s -> s.split(":"))
                            .allMatch(s -> checkData(s[0], s[1]));
        }

        private boolean checkData(String key, String value) {
            if (key.equals("cid")) {
                return true;
            }
            Pattern p = Pattern.compile(mandatoryFields.get(key));
            return p.matcher(value).matches();
        }

    }

}