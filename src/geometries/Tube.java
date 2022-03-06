//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry {
    final Ray axisRay;
    final double radius;

    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    public Ray getAxisRay() {
        return this.axisRay;
    }

    public double getRadius() {
        return this.radius;
    }

    public String toString() {
        return "Tube{axisRay=" + this.axisRay + ", radius=" + this.radius + "}";
    }

    public Vector getNormal(Point point) {
        return null;
    }
}
