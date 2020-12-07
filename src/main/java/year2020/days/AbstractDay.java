package year2020.days;

import shared.Day;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public abstract class AbstractDay extends Day {
    private static final int YEAR = 2020;

    public AbstractDay(int day) {
        super(YEAR, day);
    }

    public abstract void solvePart1();

    public abstract void solvePart2();

    public abstract int getDay();

}