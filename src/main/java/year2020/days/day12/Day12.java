package year2020.days.day12;

import year2020.days.AbstractDay2020;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 21.12.2020
 */

public class Day12 extends AbstractDay2020 {

    private static final int DAY = 12;

    public Day12() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        List<Instruction> instructions = parseStringToList(getStringFromInput(puzzleInput));
        return String.valueOf(getManhattanDistance(instructions, new Point(0, 0)));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        List<Instruction> instructions = parseStringToList(getStringFromInput(puzzleInput));
        return String.valueOf(getManhattanDistance2(instructions, new Point(10, 1)));
    }

    private List<Instruction> parseStringToList(String str) {
        String[] arr = str.split("\r\n");
        return Arrays.stream(arr).map(Instruction::new).collect(Collectors.toList());
    }

    private int getManhattanDistance(List<Instruction> instructions, Point point) {
        int x = point.x;
        int y = point.y;
        int degrees = 0;
        for (Instruction instruction : instructions) {
            char action = instruction.action;
            int value = instruction.value;
            switch (action) {
                case 'N' -> y += value;
                case 'E' -> x += value;
                case 'S' -> y -= value;
                case 'W' -> x -= value;
                case 'R' -> {
                    degrees += value;
                    if (degrees >= 360) degrees -= 360;
                }
                case 'L' -> {
                    degrees -= value;
                    if (degrees < 0) degrees += 360;
                }
                case 'F' -> {
                    if (degrees == 0) x += value;
                    else if (degrees == 90) y -= value;
                    else if (degrees == 180) x -= value;
                    else if (degrees == 270) y += value;
                }

            }
        }
        return Math.abs(x) + Math.abs(y);
    }

    private int getManhattanDistance2(List<Instruction> instructions, Point point) {
        int x = 0;
        int y = 0;
        for (Instruction instruction : instructions) {
            char action = instruction.action;
            int value = instruction.value;
            switch (action) {
                case 'N' -> point.y += value;
                case 'E' -> point.x += value;
                case 'S' -> point.y -= value;
                case 'W' -> point.x -= value;
                case 'R' -> {
                    for (int i = 0; i < value; i += 90) {
                        point = new Point(point.y, -1 * point.x);
                    }
                }
                case 'L' -> {
                    for (int i = 0; i < value; i += 90) {
                        point = new Point(-1 * point.y, point.x);
                    }
                }
                case 'F' -> {
                    x += value * point.x;
                    y += value * point.y;
                }
            }
        }
        return Math.abs(x) + Math.abs(y);
    }

    private static class Instruction {

        private char action;
        private int value;

        public Instruction(String str) {
            action = str.charAt(0);
            try {
                value = Integer.parseInt(str.substring(1));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

}
