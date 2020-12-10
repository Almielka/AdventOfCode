package year2020;

import year2020.days.*;

import java.util.List;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public class Application {
    private static final List<AbstractDay> DAYS = List.of(
            new Day01(),
            new Day02(),
            new Day03(),
            new Day04()
    );

    public static void main(String[] args) {
        DAYS.forEach(day -> {
            System.out.println("Day " + day.getDay() + ", Part 1: " + day.solvePart1());
            System.out.println("Day " + day.getDay() + ", Part 2: " + day.solvePart2());
        });
    }
}
