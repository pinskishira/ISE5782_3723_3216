package lighting;

import primitives.Color;
import primitives.Double3;
import primitives.Point;
import primitives.Vector;

import java.util.List;

/**
 * Class represents directional light in a scene
 * Extends abstract class Light and implements interface LightSource
 */
public class DirectionalLight extends Light implements LightSource {
    // Field represents the direction of the light
    private Vector direction;

    /**
     * Constructor for DirectionalLight
     * @param intensity parameter for field intensity in super
     * @param direction parameter for field direction
     */
    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction;
    }

    @Override
    public Color getIntensity(Point p) {
        //intensity of directional light is the same in every point
        return super.getIntensity();
    }

    @Override
    public Vector getL(Point p) {
        return direction.normalize();
    }

    @Override
    public double getDistance(Point point) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public List<Vector> getBeamL(Point dummyPoint3D, double dummyRadius, int dummyInt) {
        return List.of(new Vector(new Double3(direction.get_x(),direction.get_y(),direction.get_z())));
    }
}

