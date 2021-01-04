package year2020.days.day18;

import year2020.days.AbstractDay2020;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 04.01.2021
 */

public class Day18 extends AbstractDay2020 {

    private static final int DAY = 18;

    public Day18() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(resultingValues(puzzleInput).stream().mapToLong(Long::longValue).sum());
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return null;
    }

    private List<Long> resultingValues(String puzzleInput) {
        if (puzzleInput.equals(String.valueOf(DAY))) {
            puzzleInput = getStringFromInput(puzzleInput);
        }
        String[] arr = puzzleInput.split("\r\n");
        return Arrays.stream(arr).map(this::shuntingYardAlgorithm).collect(Collectors.toList());
    }

    private long shuntingYardAlgorithm(String infixNotation) {
        Stack<Character> stack = new Stack<>();
        Stack<Long> value = new Stack<>();
        for (char c : infixNotation.toCharArray()) {
            switch (c) {
                case '+', '*' -> {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        stack.push(c);
                    } else if (stack.peek() == '+' || stack.peek() == '*') {
                        value.push(calculate(value.pop(), stack.pop(), value.pop()));
                        stack.push(c);
                    } else {
                        stack.push(c);
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (stack.peek() != '(') {
                        value.push(calculate(value.pop(), stack.pop(), value.pop()));
                    }
                    stack.pop();
                }
                default -> {
                    if (Character.isDigit(c)) {
                        value.push(Long.parseLong(String.valueOf(c)));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            value.push(calculate(value.pop(), stack.pop(), value.pop()));
        }
        return value.pop();
    }

    private long calculate(long first, char sign, long second) {
        return switch (sign){
            case '+' -> first + second;
            case '*' -> first * second;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
    }
}