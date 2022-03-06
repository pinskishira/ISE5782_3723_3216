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

    public Plane(Point p1, Point p2, Point p3) {
        this._q0 = p1;
        //        //TODO check direction of vectors
//        Vector U = p1.subtract(p2);
//        Vector V = p3.subtract(p2);

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector N = U.crossProduct(V);
        //right hand rule
        this._normal = N.normalize();
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
