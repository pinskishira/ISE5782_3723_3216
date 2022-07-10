package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

import java.util.*;

import static primitives.Util.isZero;

/**
 * Class represents a light source from a point
 * Extends abstract class Light
 * Implements interface LightSource
 */
public class PointLight extends Light implements LightSource {
    // Field represents the position point in which the light lies
    protected Point position;
    private  static final Random RND= new Random();
    // Fields represent the attenuation factors
    protected double kC = 1;
    protected double kL = 0;
    protected double kQ = 0;

    /**
     * Constructor
     *
     * @param intensity parameter for Field intensity in super
     * @param position  parameter for field position
     */
    public PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
        this.kC = kC;
        this.kL = kL;
        this.kQ = kQ;
    }

    /**
     * Builder pattern setter for field kC
     *
     * @param kC parameter for field kC
     * @return PointLight object
     */
    public PointLight setKc(double kC) {
        this.kC = kC;
        return this;
    }

    /**
     * Builder pattern setter for field kL
     *
     * @param kL parameter for field kL
     * @return PointLight object
     */
    public PointLight setKl(double kL) {
        this.kL = kL;
        return this;
    }

    /**
     * Builder pattern setter for field kQ
     *
     * @param kQ parameter for field kQ
     * @return PointLight object
     */
    public PointLight setKq(double kQ) {
        this.kQ = kQ;
        return this;
    }

    @Override
    public Color getIntensity(Point p) {
        double d = p.distance(position);
        double ds = p.distanceSquared(position);
        Color i0 = super.getIntensity();

        //intensity reduced by attenuation factors and distance according to formula:
        //i0/(kc+d*kl+d^2*kq)
        return i0.reduce(kC + kL * d + kQ * ds);
    }

    @Override
    public Vector getL(Point p) {
        if (p.equals(position)) {
            return null;
        }

        //p-position
        return p.subtract(position).normalize();
    }

    @Override
    public double getDistance(Point pnt)
    {
        return pnt.distance(position);
    }

    @Override
    public List<Vector> getBeamL(Point p, double radius, int amount) {
        if (p.equals(position)) {
            return null;
        }
        LinkedList<Vector> beam = new LinkedList<>();

        //from pointlight position to p point
        Vector v = this.getL(p);
        beam.add(v);
        if (amount <= 1) {
            return beam;
        }

        double distance = this.position.distance(p);

        if (isZero(distance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point lightHead = new Point(v.get_x(),v.get_y(),v.get_z());
        Vector normX;

        // if v._head == (0,0,w) then normX.head ==(-w,0,0)
        // otherwise normX.head == (-y,x,0)
        if (isZero(lightHead.get_x()) && isZero(lightHead.get_y())) {
            normX = new Vector(lightHead.get_z() * -1, 0, 0).normalize();
        } else {
            normX = new Vector(lightHead.get_y() * -1, lightHead.get_x(), 0).normalize();
        }

        Vector normY = v.crossProduct(normX).normalize();
        double cosTheta;
        double sinTheta;

        double d;
        double x;
        double y;

        for (int counter = 0; counter < amount; counter++) {
            Point newPoint = new Point(this.position.get_x(),this.position.get_y(),this.position.get_z());
            // randomly coose cosTheta and sinTheta in the range (-1,1)
            cosTheta = 2 * RND.nextDouble() - 1;
            sinTheta = Math.sqrt(1d - cosTheta * cosTheta);

            //d ranged between -radius and  +radius
            d = radius * (2 * RND.nextDouble() - 1);
            //d ranged between -radius and  +radius
            if (isZero(d)) { //Thanks to Michael Shachor
                counter--;
                continue;
            }
            x = d * cosTheta;
            y = d * sinTheta;

            if (!isZero(x)) {
                newPoint = newPoint.add(normX.scale(x));
            }
            if (!isZero(y)) {
                newPoint = newPoint.add(normY.scale(y));
            }
            beam.add(p.subtract(newPoint).normalize());
        }
        return beam;

    }
}
