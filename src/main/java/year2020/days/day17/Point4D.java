package year2020.days.day17;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anna S. Almielka
 * 03.01.2021
 */

public class Point4D {

    private int x;
    private int y;
    private int z;
    private int w;

    public Point4D(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Set<Point4D> getNeighbors() {
        Set<Point4D> neighbors = new HashSet<>();
        for (int x = this.x - 1; x <= this.x + 1; x++) {
            for (int y = this.y - 1; y <= this.y + 1; y++) {
                for (int z = this.z - 1; z <= this.z + 1; z++) {
                    for (int w = this.w - 1; w <= this.w + 1; w++) {
                        if (x == this.x && y == this.y && z == this.z && w == this.w) continue;
                        neighbors.add(new Point4D(x, y, z, w));
                    }
                }
            }
        }
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point4D point4D = (Point4D) o;

        if (x != point4D.x) return false;
        if (y != point4D.y) return false;
        if (z != point4D.z) return false;
        return w == point4D.w;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        result = 31 * result + w;
        return result;
    }
}
