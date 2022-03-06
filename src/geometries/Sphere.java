//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere implements Geometry {
    final Point _center;
    final double radius;

    public Sphere(Point center, double radius) {
        this._center = center;
        this.radius = radius;
    }

    public Vector getNormal(Point point) {
        Vector n=point.subtract(_center);
        return n.normalize();
    }

    public String toString() {
        return "Sphere{center=" + this._center + ", radius=" + this.radius + "}";
    }
}
