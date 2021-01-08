package year2020.days.day19;

import year2020.days.AbstractDay2020;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 05.01.2021
 */

public class Day19 extends AbstractDay2020 {

    private static final int DAY = 19;

    public Day19() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(countMatchMessages(getStringFromInput(puzzleInput)));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return null;
    }

    private int countMatchMessages(String str) {
        String[] arrRules = str.split("\r\n\r\n")[0].split("\r\n");
        String[] arrMessages = str.split("\r\n\r\n")[1].split("\r\n");
        Map<Integer, String> rules = Arrays.stream(arrRules)
                .map(s -> s.split(":\\s"))
                .filter(s -> s.length == 2)
                .collect(Collectors.toMap(s -> Integer.parseInt(s[0]), s -> s[1]));
        List<String> possiblyStrings = getPossiblyStrings(rules.get(0), rules);
        return (int) Arrays.stream(arrMessages).filter(possiblyStrings::contains).count();
    }

    private List<String> getPossiblyStrings(String rule, Map<Integer, String> rules) {
        List<String> result = new ArrayList<>(Collections.singletonList(""));
        String[] arr = rule.split("\\s");
        for (String s : arr) {
            int nextIndex = Integer.parseInt(s);
            String currentRule = rules.get(nextIndex);
            if (currentRule.startsWith("\"")) {
                for (int i = 0; i < result.size(); i++) {
                    result.set(i, result.get(i) + currentRule.charAt(1));
                }
            } else {
                int length = result.size();
                for (int i = 0; i < length; i++) {
                    String[] subRules = currentRule.split("\\s\\|\\s");
                    String floating = result.remove(0);
                    for (String possiblyString : getPossiblyStrings(subRules[0], rules)) {
                        result.add(floating + possiblyString);
                    }
                    if (currentRule.contains("|")) {
                        for (String possiblyString : getPossiblyStrings(subRules[1], rules)) {
                            result.add(floating + possiblyString);
                        }
                    }
                }
            }
        }
        return result;
    }

}