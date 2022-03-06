//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package primitives;

public class Vector extends Point {
    public Vector(double x, double y, double z) {
        this(new Double3(x, y, z));
    }

    public Vector(Double3 xyz) {
        super(xyz);
        if (this._xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not allowed");
        }
    }

    public double lengthSquared() {
        return this._xyz._d1 * this._xyz._d1 + this._xyz._d2 * this._xyz._d2 + this._xyz._d3 * this._xyz._d3;
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double dotProduct(Vector v3) {
        return v3._xyz._d1 * this._xyz._d1 + v3._xyz._d2 * this._xyz._d2 + v3._xyz._d3 * this._xyz._d3;
    }

    public Vector crossProduct(Vector v3) {
        double ax = this._xyz._d1;
        double ay = this._xyz._d2;
        double az = this._xyz._d3;
        double bx = v3._xyz._d1;
        double by = v3._xyz._d2;
        double bz = v3._xyz._d3;
        double cx = ay * bz - az * by;
        double cy = az * bx - ax * bz;
        double cz = ax * by - ay * bx;
        return new Vector(cx, cy, cz);
    }

    public Vector normalize() {
        double len = this.length();
        if (len == 0.0D) {
            throw new ArithmeticException("Divide by zero!");
        } else {
            return new Vector(this._xyz.reduce(len));
        }
    }

    public Vector scale(double scalar) {
        return new Vector(this._xyz.scale(scalar));
    }
}
