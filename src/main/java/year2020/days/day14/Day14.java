package year2020.days.day14;

import year2020.days.AbstractDay2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.IntStream.range;

/**
 * @author Anna S. Almielka
 * 23.12.2020
 */

public class Day14 extends AbstractDay2020 {

    private static final int DAY = 14;

    public Day14() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        Map<Long, Long> memory = parseStringToMapMemory(getStringFromInput(puzzleInput));
        return String.valueOf(memory.values().stream().mapToLong(Long::longValue).sum());
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return String.valueOf("0");
    }

    private Map<Long, Long> parseStringToMapMemory(String str) {
        String[] arr = str.split("mask\s=\s");
        Map<Long, Long> memory = new HashMap<>();
        range(1, arr.length).forEach(i -> {
            Program program = new Program(arr[i]);
            memory.putAll(program.instructions);
        });
        return memory;
    }

    private static class Program {

        private String mask;
        private Map<Long, Long> instructions;

        public Program(String str) {
            String[] input = str.split("\r\n");
            mask = input[0];
            instructions = new HashMap<>();
            range(1, input.length).forEach(i -> {
                List<Long> list = parseStringToList(input[i]);
                Long newValue = getNewValue(list.get(1));
                instructions.put(list.get(0), newValue);
            });
        }

        private List<Long> parseStringToList(String str) {
            List<Long> list = new ArrayList<>();
            Matcher m = Pattern.compile("^mem\\[(\\d+)]\\s=\\s(\\d+)$").matcher(str);
            while (m.find()) {
                list.add(Long.parseLong(m.group(1)));
                list.add(Long.parseLong(m.group(2)));
            }
            return list;
        }

        private Long getNewValue(Long oldValue) {
            String binaryValue = getBinaryString(oldValue);
            StringBuilder newValue = new StringBuilder(binaryValue);
            for (int i = 0; i < mask.length(); i++) {
                if (mask.charAt(i) == '0') {
                    newValue.setCharAt(i, '0');
                }
                if (mask.charAt(i) == '1') {
                    newValue.setCharAt(i, '1');
                }
            }
            return Long.parseLong(String.valueOf(newValue), 2);
        }

        private String getBinaryString(Long old) {
            return String.format("%36s", Long.toBinaryString(old)).replace(' ', '0');
        }

    }

}


