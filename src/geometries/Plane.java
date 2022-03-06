//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry {
    final Point _q0;
    final Vector _normal;

    public Point getQ0() {
        return this._q0;
    }

    /** @deprecated */
    public Plane(Point q0, Vector normal) {
        this._q0 = q0;
        this._normal = normal.normalize();
    }

    public Plane(Point vertex, Point vertex1, Point vertex2) {
        this._q0 = vertex;
        Vector U = vertex1.subtract(vertex);
        Vector V = vertex2.subtract(vertex);
        Vector N = U.crossProduct(V);
        N.normalize();
        this._normal = N;
    }

    public Vector getNormal() {
        return this._normal;
    }

    public Vector getNormal(Point point) {
        return this.getNormal();
    }

    public String toString() {
        return "Plane{_q0=" + this._q0 + ", _normal=" + this._normal + "}";
    }
}
