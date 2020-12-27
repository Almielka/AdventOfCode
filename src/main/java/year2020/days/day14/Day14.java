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
        Map<Long, Long> memory = parseStringToMapMemory(getStringFromInput(puzzleInput), 1);
        return String.valueOf(memory.values().stream().mapToLong(Long::longValue).sum());
    }

    @Override
    public String solvePart2(String puzzleInput) {
        Map<Long, Long> memory = parseStringToMapMemory(getStringFromInput(puzzleInput), 2);
        return String.valueOf(memory.values().stream().mapToLong(Long::longValue).sum());
    }

    private Map<Long, Long> parseStringToMapMemory(String str, int number) {
        String[] arr = str.split("mask\s=\s");
        Map<Long, Long> memory = new HashMap<>();
        range(1, arr.length).forEach(i -> {
            Program program = new Program(arr[i], number);
            memory.putAll(program.instructions);
        });
        return memory;
    }

    private static class Program {

        private String mask;
        private Map<Long, Long> instructions;

        public Program(String str, int number) {
            String[] input = str.split("\r\n");
            mask = input[0];
            instructions = new HashMap<>();
            range(1, input.length).forEach(i -> {
                List<Long> list = parseStringToList(input[i]);
                if (number == 1) {
                    Long newValue = parseBinaryStringToLong(getNewValue(list.get(1)));
                    instructions.put(list.get(0), newValue);
                }
                if (number == 2) {
                    List<String> newAddresses = getNewAddresses(list.get(0));
                    newAddresses.forEach(k ->
                            instructions.put(parseBinaryStringToLong(k), list.get(1)));
                }
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

        private String getNewValue(Long oldValue) {
            String binaryValue = parseLongToBinaryString(oldValue);
            StringBuilder newValue = new StringBuilder(binaryValue);
            for (int i = 0; i < mask.length(); i++) {
                if (mask.charAt(i) == '0') {
                    newValue.setCharAt(i, '0');
                }
                if (mask.charAt(i) == '1') {
                    newValue.setCharAt(i, '1');
                }
            }
            return String.valueOf(newValue);
        }

        private List<String> getNewAddresses(Long oldAddress) {
            List<String> result = new ArrayList<>(Collections.singletonList(""));
            String binaryAddress = parseLongToBinaryString(oldAddress);
            for (int j = 0; j < mask.length(); j++) {
                switch (mask.charAt(j)) {
                    case '0' -> {
                        for (int i = 0; i < result.size(); i++) {
                            result.set(i, result.get(i) + binaryAddress.charAt(j));
                        }
                    }
                    case '1' -> {
                        for (int i = 0; i < result.size(); i++) {
                            result.set(i, result.get(i) + "1");
                        }
                    }
                    case 'X' -> {
                        int length = result.size();
                        for (int i = 0; i < length; i++) {
                            String floating = result.remove(0);
                            result.add(floating + "0");
                            result.add(floating + "1");
                        }
                    }
                }
            }
            return result;
        }

        private String parseLongToBinaryString(Long old) {
            return String.format("%36s", Long.toBinaryString(old)).replace(' ', '0');
        }

        private Long parseBinaryStringToLong(String str) {
            return Long.parseLong(String.valueOf(str), 2);
        }

    }

}


