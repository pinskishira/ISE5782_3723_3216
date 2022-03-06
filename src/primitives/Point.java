//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package primitives;

import java.util.Objects;

public class Point {
    final Double3 _xyz;

    public String toString() {
        return "Point{" + this._xyz + "}";
    }

    public Point(double x, double y, double z) {
        this._xyz = new Double3(x, y, z);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Point point = (Point)o;
            return Objects.equals(this._xyz, point._xyz);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this._xyz});
    }

    public Point(Double3 xyz) {
        this._xyz = xyz;
    }

    public double distanceSquared(Point other) {
        double x1 = this._xyz._d1;
        double y1 = this._xyz._d2;
        double z1 = this._xyz._d3;
        double x2 = other._xyz._d1;
        double y2 = other._xyz._d1;
        double z2 = other._xyz._d1;
        return x1 * x1 + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1);
    }

    public double distance(Point other) {
        return Math.sqrt(this.distanceSquared(other));
    }

    public Point add(Vector vector) {
        return new Point(this._xyz.add(vector._xyz));
    }

    public Vector subtract(Point p1) {
        return new Vector(this._xyz.subtract(p1._xyz));
    }
}
