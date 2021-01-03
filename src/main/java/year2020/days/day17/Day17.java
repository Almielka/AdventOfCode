package year2020.days.day17;

import year2020.days.AbstractDay2020;

import java.util.HashSet;
import java.util.Set;


import static java.util.stream.IntStream.range;

/**
 * @author Anna S. Almielka
 * 02.01.2021
 */

public class Day17 extends AbstractDay2020 {

    private static final int DAY = 17;

    public Day17() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        Grid grid = new Grid(getStringFromInput(puzzleInput));
        range(0, 6).forEach(i -> grid.goSimulate3D());
        return String.valueOf(grid.active3D.size());
    }

    @Override
    public String solvePart2(String puzzleInput) {
        Grid grid = new Grid(getStringFromInput(puzzleInput));
        range(0, 6).forEach(i -> grid.goSimulate4D());
        return String.valueOf(grid.active4D.size());
    }

    private class Grid {
        private Set<Point3D> active3D;
        private Set<Point4D> active4D;

        public Grid(String str) {
            String[] arr = str.split("\r\n");
            int z = 0, w = 0;
            active3D = new HashSet<>();
            active4D = new HashSet<>();
            for (int x = 0; x < arr.length; x++) {
                for (int y = 0; y < arr[x].length(); y++) {
                    if (arr[x].charAt(y) == '#') {
                        active3D.add(new Point3D(x, y, z));
                        active4D.add(new Point4D(x, y, z, w));
                    }
                }
            }
        }

        private void goSimulate3D() {
            Set<Point3D> newActive = new HashSet<>();
            // active points
            for (Point3D point3D : active3D) {
                long activeNeighbors = point3D.getNeighbors().stream().filter(neighbor -> active3D.contains(neighbor)).count();
                if (activeNeighbors == 2 || activeNeighbors == 3) {
                    newActive.add(point3D);
                }
            }

            // inactive points
            active3D.stream()
                    .flatMap(point -> point.getNeighbors().stream())
                    .filter(point -> !active3D.contains(point))
                    .forEach(point -> {
                                long activeNeighbors = point.getNeighbors().stream().filter(neighbor -> active3D.contains(neighbor)).count();
                                if (activeNeighbors == 3) {
                                    newActive.add(point);
                                }
                            }
                    );
            active3D = newActive;
        }

        private void goSimulate4D() {
            Set<Point4D> newActive = new HashSet<>();
            // active points
            for (Point4D point4D : active4D) {
                long activeNeighbors = point4D.getNeighbors().stream().filter(neighbor -> active4D.contains(neighbor)).count();
                if (activeNeighbors == 2 || activeNeighbors == 3) {
                    newActive.add(point4D);
                }
            }

            // inactive points
            active4D.stream()
                    .flatMap(point -> point.getNeighbors().stream())
                    .filter(point -> !active4D.contains(point))
                    .forEach(point -> {
                                long activeNeighbors = point.getNeighbors().stream().filter(neighbor -> active4D.contains(neighbor)).count();
                                if (activeNeighbors == 3) {
                                    newActive.add(point);
                                }
                            }
                    );
            active4D = newActive;
        }
    }

}
