package year2020.days.day17;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anna S. Almielka
 * 03.01.2021
 */
class Point3D {

    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Set<Point3D> getNeighbors() {
        Set<Point3D> neighbors = new HashSet<>();
        for (int x = this.x - 1; x <= this.x + 1; x++) {
            for (int y = this.y - 1; y <= this.y + 1; y++) {
                for (int z = this.z - 1; z <= this.z + 1; z++) {
                    if (x == this.x && y == this.y && z == this.z) continue;
                    neighbors.add(new Point3D(x, y, z));
                }
            }
        }
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point3D point3D = (Point3D) o;

        if (x != point3D.x) return false;
        if (y != point3D.y) return false;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

}
