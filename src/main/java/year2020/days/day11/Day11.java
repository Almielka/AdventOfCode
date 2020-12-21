package year2020.days.day11;

import year2020.days.AbstractDay2020;

/**
 * @author Anna S. Almielka
 * 18.12.2020
 */

public class Day11 extends AbstractDay2020 {

    private static final int DAY = 11;
    private static final char SEAT = 'L';
    private static final char FLOOR = '.';
    private static Seat[][] seatingArea;
    private static int countOccupied;
    private static final int ADJACENT = 4;
    private static final int VISIBLE = 5;

    public Day11() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(occupySeatingArea(getSeatingArea(getStringFromInput(DAY)), ADJACENT));
    }

    @Override
    public String solvePart2() {
        return String.valueOf(occupySeatingArea(getSeatingArea(getStringFromInput(DAY)), VISIBLE));
    }

    private Seat[][] getSeatingArea(String str) {
        String[] arr = str.split("\r\n");
        seatingArea = new Seat[arr.length][arr[0].length()];
        countOccupied = 0;
        for (int x = 0; x < arr.length; x++) {
            String line = arr[x];
            for (int y = 0; y < line.length(); y++) {
                if (line.charAt(y) == SEAT) {
                    seatingArea[x][y] = new Seat(x, y, true);
                } else if (line.charAt(y) == FLOOR) {
                    seatingArea[x][y] = new Seat(x, y, false);
                }
            }
        }
        return seatingArea;
    }

    private int occupySeatingArea(Seat[][] seatingArea, int value) {
        int checkSeat = seatingArea.length * seatingArea[0].length;
        for (Seat[] seatsRow : seatingArea) {
            for (Seat currentSeat : seatsRow) {
                if (currentSeat.isSeat && !currentSeat.isOccupied && currentSeat.countNeighbors == 0) {
                    currentSeat.isOccupied = true;
                    countOccupied++;
                } else if (currentSeat.isSeat && currentSeat.isOccupied && currentSeat.countNeighbors >= value) {
                    currentSeat.isOccupied = false;
                    countOccupied--;
                } else {
                    checkSeat--;
                }
            }
        }
        countOccupied(value);
        if (checkSeat != 0) occupySeatingArea(seatingArea, value);
        return countOccupied;
    }

    private void countOccupied(int value) {
        for (Seat[] seatsRow : seatingArea) {
            for (Seat currentSeat : seatsRow) {
                if (currentSeat.isSeat) {
                    if (value == ADJACENT) currentSeat.countNeighbors = getAdjacentNeighbors(currentSeat);
                    else if (value == VISIBLE) currentSeat.countNeighbors = getVisibleNeighbors(currentSeat);
                }
            }
        }
    }

    private int getAdjacentNeighbors(Seat seat) {
        int result = 0;
        for (int x = seat.x - 1; x <= seat.x + 1; x++) {
            for (int y = seat.y - 1; y <= seat.y + 1; y++) {
                if (!isInArea(x, y)) continue;
                if (!seatingArea[x][y].equals(seat) && seatingArea[x][y].isOccupied) result++;
            }
        }
        return result;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < seatingArea.length && y >= 0 && y < seatingArea[x].length;
    }

    private int getVisibleNeighbors(Seat seat) {
        int result = 0;
        for (int rangeX = -1; rangeX <= 1; rangeX++) {
            for (int rangeY = -1; rangeY <= 1; rangeY++) {
                if (rangeX == 0 && rangeY == 0) continue;
                if (hasVisibleOccupiedSeat(seat.x, seat.y, rangeX, rangeY)) result++;
            }
        }
        return result;
    }

    boolean hasVisibleOccupiedSeat(int x, int y, int rangeX, int rangeY) {
        do {
            x += rangeX;
            y += rangeY;
        }
        while (isInArea(x, y) && !seatingArea[x][y].isSeat);

        return isInArea(x, y) && seatingArea[x][y].isOccupied;
    }

    private static class Seat {
        private final int x;
        private final int y;
        private int countNeighbors;
        private final boolean isSeat;
        private boolean isOccupied;

        public Seat(int x, int y, boolean isSeat) {
            this.x = x;
            this.y = y;
            this.isSeat = isSeat;
        }

    }

}