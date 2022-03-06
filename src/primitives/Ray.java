//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package primitives;

import java.util.Objects;

public class Ray {
    final Point p0;
    final Vector dir;

    public String toString() {
        return "Ray{p0=" + this.p0 + ", dir=" + this.dir + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Ray ray = (Ray)o;
            return Objects.equals(this.p0, ray.p0) && Objects.equals(this.dir, ray.dir);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.p0, this.dir});
    }

    public Point getP0() {
        return this.p0;
    }

    public Vector getDir() {
        return this.dir;
    }

    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalize();
    }
}
