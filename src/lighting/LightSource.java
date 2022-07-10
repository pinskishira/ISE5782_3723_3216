package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

import java.util.List;

/**
 * Interface for light sources to implement
 */
public interface LightSource {
    /**
     * Returns light intensity at given point
     * @param p the point
     * @return Color object
     */
    public Color getIntensity(Point p);

    /**
     * Returns the direction of the light at given point
     * @param p the point
     * @return Vector object
     */
    public Vector getL(Point p);
    public double getDistance(Point pnt);

    public List<Vector> getBeamL(Point p,double redius , int amount);
}
