package year2020.days;

import shared.AbstractDay;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public abstract class AbstractDay2020 extends AbstractDay {

    private static final int YEAR = 2020;

    public AbstractDay2020(int day) {
        super(YEAR, day);
    }

    public abstract String solvePart1();
    public abstract String solvePart2();

}