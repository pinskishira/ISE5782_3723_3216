package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

import java.util.List;

/**
 * RayTracerBase abstract class that use as an interface for RayTracerBasic
 *
 */
public abstract class RayTracerBase {

    /**
     * The scene of the image
     */
    protected Scene scene;

    /**
     * A builder function that get a scene
     * @param scene
     */
    public RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * An abstract function that get a ray and return the color of the point that cross the ray
     * @param ray ray that intersect the scene
     * @return Color
     */
    public abstract Color traceRay(Ray ray);
    public abstract Color traceRay(List<Ray> rays);
    protected double beamRadius=20d;
    protected boolean softShadows=false;

}
