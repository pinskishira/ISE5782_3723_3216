//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package geometries;

import primitives.Point;

public class Triangle extends Polygon {
    Triangle(Point p1, Point p2, Point p3) {
        super(new Point[]{p1, p2, p3});
    }

    public String toString() {
        return "Triangle{vertices=" + this.vertices + ", plane=" + this.plane + "}";
    }
}
