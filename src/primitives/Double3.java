//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package primitives;

public class Double3 {
    final double _d1;
    final double _d2;
    final double _d3;
    static final Double3 ZERO = new Double3(0.0D, 0.0D, 0.0D);

    protected Double3(double d1, double d2, double d3) {
        this._d1 = d1;
        this._d2 = d2;
        this._d3 = d3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (!(obj instanceof Double3)) {
            return false;
        } else {
            Double3 other = (Double3)obj;
            return Util.isZero(this._d1 - other._d1) && Util.isZero(this._d2 - other._d2) && Util.isZero(this._d3 - other._d3);
        }
    }

    public int hashCode() {
        return (int)Math.round(this._d1 + this._d2 + this._d3);
    }

    public String toString() {
        return "(" + this._d1 + "," + this._d2 + "," + this._d3 + ")";
    }

    Double3 add(Double3 rhs) {
        return new Double3(this._d1 + rhs._d1, this._d2 + rhs._d2, this._d3 + rhs._d3);
    }

    Double3 subtract(Double3 rhs) {
        return new Double3(this._d1 - rhs._d1, this._d2 - rhs._d2, this._d3 - rhs._d3);
    }

    Double3 scale(double rhs) {
        return new Double3(this._d1 * rhs, this._d2 * rhs, this._d3 * rhs);
    }

    Double3 reduce(double rhs) {
        return new Double3(this._d1 / rhs, this._d2 / rhs, this._d3 / rhs);
    }

    Double3 product(Double3 rhs) {
        return new Double3(this._d1 * rhs._d1, this._d2 * rhs._d2, this._d3 * rhs._d3);
    }
}
