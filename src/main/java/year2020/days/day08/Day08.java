package year2020.days.day08;

import year2020.days.AbstractDay2020;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 13.12.2020
 */

public class Day08 extends AbstractDay2020 {

    private static final int DAY = 8;
    private static final String ACC = "acc";
    private static final String JMP = "jmp";
    private static final String NOP = "nop";

    public Day08() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(getAccumulatorFromFalseLoop(parseStringToList(getStringFromInput(DAY))).get(false));
    }

    @Override
    public String solvePart2() {
        return String.valueOf(getAccumulatorFromCorrectLoop(parseStringToList(getStringFromInput(DAY))).get(true));
    }

    private List<Instruction> parseStringToList(String str) {
        String[] arr = str.split("\r\n");
        return Arrays.stream(arr).map(Instruction::new).collect(Collectors.toList());
    }

    private Map<Boolean, Integer> getAccumulatorFromFalseLoop(List<Instruction> list) {
        Set<Integer> set = new HashSet<>();
        int accumulator = 0;
        boolean isCorrect = true;
        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(i)) {
                set.add(i);
                int arg = list.get(i).argument;
                String op = list.get(i).operation;
                if (op.equals(ACC)) accumulator += arg;
                if (op.equals(JMP)) i += arg - 1;
            } else {
                isCorrect = false;
                break;
            }
        }
        return Map.of(isCorrect, accumulator);
    }

    private Map<Boolean, Integer> getAccumulatorFromCorrectLoop(List<Instruction> list) {
        int accumulator = 0;
        boolean isCorrect = true;
        for (int k = 0; k < list.size(); k++) {
            List<Instruction> copy = new ArrayList<>(List.copyOf(list));
            if (list.get(k).operation.equals(JMP))
                copy.set(k, new Instruction(NOP + " " + list.get(k).argument));
            else if (list.get(k).operation.equals(NOP))
                copy.set(k, new Instruction(JMP + " " + list.get(k).argument));

            Map<Boolean, Integer> map = getAccumulatorFromFalseLoop(copy);
            isCorrect = (boolean) map.keySet().toArray()[0];
            accumulator = map.get(isCorrect);
            if (isCorrect) break;
        }
        return Map.of(isCorrect, accumulator);
    }

    private static class Instruction {

        private String operation;
        private int argument;

        public Instruction(String str) {
            String[] parts = str.split("\\s");
            operation = parts[0];
            try {
                argument = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}