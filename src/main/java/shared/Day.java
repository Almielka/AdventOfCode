package shared;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public abstract class Day {
    protected final int year;
    protected final int day;

    public Day(int year, int day) {
        this.year = year;
        this.day = day;
    }
}

