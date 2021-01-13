package year2020.days.day20;

import year2020.days.AbstractDay2020;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 10.01.2021
 */

public class Day20 extends AbstractDay2020 {

    private static final int DAY = 20;

    public Day20() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {

        List<Tile> tiles = parseString(getStringFromInput(puzzleInput));

        Set<String> allBorders = getAllBorders(tiles);
        allBorders.addAll(getReverse(allBorders));

        List<Tile> angles = tiles.stream()
                .filter(t -> t.isAngle(allBorders))
                .collect(Collectors.toList());
        long result = 1;
        for (Tile tile : angles) {
            result *= tile.id;
        }
        return String.valueOf(result);
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return null;
    }

    private List<Tile> parseString(String str) {
        String[] arr = str.split("\r\n\r\n");
        return Arrays.stream(arr).map(Tile::new).collect(Collectors.toList());
    }

    private Set<String> getReverse(Set<String> set) {
        return set.stream()
                .map(s -> String.valueOf(new StringBuilder(s).reverse()))
                .collect(Collectors.toSet());
    }

    private Set<String> getAllBorders(List<Tile> tiles) {
        Set<String> allBorders = new HashSet<>();
        for (Tile currentTile : tiles) {
            Set<String> rotated = currentTile.getBorders();
            Set<String> flipped = getReverse(rotated);

            for (Tile otherTile : tiles) {
                if (currentTile.equals(otherTile)) continue;
                Set<String> otherRotated = otherTile.getBorders();
                Set<String> otherFlipped = getReverse(otherRotated);
                if (getBorder(rotated, otherRotated).isPresent()) {
                    allBorders.add(getBorder(rotated, otherRotated).get());
                } else if (getBorder(rotated, otherFlipped).isPresent()) {
                    allBorders.add(getBorder(rotated, otherFlipped).get());
                } else if (getBorder(flipped, otherRotated).isPresent()) {
                    allBorders.add(getBorder(flipped, otherRotated).get());
                } else if (getBorder(flipped, otherFlipped).isPresent()) {
                    allBorders.add(getBorder(flipped, otherFlipped).get());
                }
            }
        }
        return allBorders;
    }

    private Optional<String> getBorder(Set<String> current, Set<String> other) {
        return current.stream()
                .filter(other::contains)
                .findFirst();
    }

    private static class Tile {

        private int id;
        private char[][] grid = new char[10][10];
        private Set<String> borders = new HashSet<>();

        public Tile(String str) {
            try {
                id = Integer.parseInt(str.split(":")[0].replace("Tile ", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            String[] ar = str.split(":\r\n")[1].split("\r\n");
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar.length; j++) {
                    grid[i][j] = ar[i].charAt(j);
                }
            }
            setBorders();
        }

        private void setBorders() {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            StringBuilder str3 = new StringBuilder();
            StringBuilder str4 = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                str1.append(grid[0][i]);
                str2.append(grid[i][0]);
                str3.append(grid[i][grid.length - 1]);
                str4.append(grid[grid.length - 1][i]);
            }
            borders.add(String.valueOf(str1));
            borders.add(String.valueOf(str2));
            borders.add(String.valueOf(str3));
            borders.add(String.valueOf(str4));
        }

        private boolean isAngle(Set<String> allBorders) {
            return allBorders.stream()
                    .filter(s -> borders.contains(s))
                    .count() == 2;
        }

        public Set<String> getBorders() {
            return borders;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tile tile = (Tile) o;

            if (id != tile.id) return false;
            if (!Arrays.deepEquals(grid, tile.grid)) return false;
            return Objects.equals(borders, tile.borders);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + Arrays.deepHashCode(grid);
            result = 31 * result + (borders != null ? borders.hashCode() : 0);
            return result;
        }
    }

}
