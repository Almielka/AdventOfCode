package year2020.days.day11;

import year2020.days.AbstractDay;

import java.util.ArrayList;

/**
 * @author Anna S. Almielka
 * 18.12.2020
 */

public class Day11 extends AbstractDay {

    private static final int DAY = 11;
    private static final char SEAT = 'L';
    private static final char FLOOR = '.';
    private static Seat[][] seatingArea;
    private static int countOccupied;

    public Day11() {
        super(DAY);
    }

    @Override
    public String solvePart1() {
        return String.valueOf(occupySeatingArea(getSeatingArea(getStringFromInput(DAY))));
    }

    @Override
    public String solvePart2() {
        return String.valueOf(0);
    }

    private Seat[][] getSeatingArea(String str) {
        String[] arr = str.split("\r\n");
        seatingArea = new Seat[arr.length][arr[0].length()];
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

    private int occupySeatingArea(Seat[][] seatingArea) {
        int checkSeat = seatingArea.length * seatingArea[0].length;
        for (Seat[] seatsRow : seatingArea) {
            for (Seat currentSeat : seatsRow) {
                if (currentSeat.isSeat && !currentSeat.isOccupied && currentSeat.countNeighbors == 0) {
                    currentSeat.isOccupied = true;
                    countOccupied++;
                } else if (currentSeat.isSeat && currentSeat.isOccupied && currentSeat.countNeighbors >= 4) {
                    currentSeat.isOccupied = false;
                    countOccupied--;
                } else {
                    checkSeat--;
                }
            }
        }
        countOccupied();
        if (checkSeat != 0) occupySeatingArea(seatingArea);
        return countOccupied;
    }

    private void countOccupied() {
        for (Seat[] seatsRow : seatingArea) {
            for (Seat currentSeat : seatsRow) {
                if (currentSeat.isSeat) {
                    currentSeat.countNeighbors = getNeighbors(currentSeat).size();
                }
            }
        }
    }

    private ArrayList<Seat> getNeighbors(Seat seat) {
        ArrayList<Seat> listNeighbors = new ArrayList<>();
        for (int x = seat.x - 1; x <= seat.x + 1; x++) {
            for (int y = seat.y - 1; y <= seat.y + 1; y++) {
                try {
                    if (!seatingArea[x][y].equals(seat) && seatingArea[x][y].isOccupied) {
                        listNeighbors.add(seatingArea[x][y]);
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return listNeighbors;
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