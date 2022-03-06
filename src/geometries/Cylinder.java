//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {
    double height;

    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public String toString() {
        return "Cylinder{height=" + this.height + ", axisRay=" + this.axisRay + ", radius=" + this.radius + "}";
    }

    public Vector getNormal(Point point) {
        return null;
    }
}
