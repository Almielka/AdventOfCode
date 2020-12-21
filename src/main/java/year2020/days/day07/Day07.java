package year2020.days.day07;

import year2020.days.AbstractDay2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.IntStream.range;

/**
 * @author Anna S. Almielka
 * 12.12.2020
 */

public class Day07 extends AbstractDay2020 {

    private static final int DAY = 7;
    private static final String SHINY = "shiny gold";
    public static Set<String> checkedBags = new HashSet<>();
    static int count = 0;

    public Day07() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        countRoots(parseStringToMap(getStringFromInput(DAY)), SHINY);
        return String.valueOf(count);
    }

    @Override
    public String solvePart2() {
        return String.valueOf(countNested(parseStringToMap(getStringFromInput(DAY)), SHINY) - 1);
    }

    private Map<String, Map<String, Integer>> parseStringToMap(String data) {
        String[] arr = data.split("\r\n");
        Map<String, Map<String, Integer>> bags = new HashMap<>();
        for (String s : arr) {
            String[] arrBags = s.split(" bags contain ");
            Map<String, Integer> nestedBags = new HashMap<>();
            range(1, arrBags.length).forEach(i -> {
                Matcher m = Pattern.compile("(\\d+)\\s(.+?)\\s(bag)+?").matcher(arrBags[i]);
                while (m.find()) {
                    //bags.computeIfAbsent(arrBags[0], b -> new HashMap<>()).put(m.group(2), Integer.parseInt(m.group(1)));
                    nestedBags.put(m.group(2), Integer.parseInt(m.group(1)));
                }
            });
            bags.put(arrBags[0], nestedBags);
        }
        return bags;
    }

    private void countRoots(Map<String, Map<String, Integer>> bags, String currentBag) {
        bags.forEach((key, value) -> {
                    if (value.containsKey(currentBag)) {
                        value.forEach((k, v) -> {
                            if (!(checkedBags.contains(key))) {
                                count++;
                                checkedBags.add(key);
                                countRoots(bags, key);
                            }
                        });
                    }
                }
        );
    }

    private int countNested(Map<String, Map<String, Integer>> bags, String currentBag) {
        return bags.get(currentBag).entrySet().stream()
                .mapToInt(v -> v.getValue() * countNested(bags, v.getKey()))
                .sum() + 1;
    }

}



