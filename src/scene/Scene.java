package scene;

import lighting.AmbientLight;
import geometries.Geometries;
import lighting.LightSource;
import primitives.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Class scene
 */
public class Scene {

    /**
     * Name of the scene
     */
    public String name;
    /**
     * Color of the background. The default is black
     */
    public Color background= Color.BLACK;
    /**
     * The default of ambient light is black
     */
    public AmbientLight ambientLight=new AmbientLight();
    /**
     * The geometry object in context of the scene
     */
    public Geometries geometries=null;
    /**
    * Field represents the lights sources in the scene
    */
    public List<LightSource> lights = new LinkedList<>();



    /**
     * create Scene
     * @param name of the scene
     */
    public Scene(String name) {
        this.name = name;
        geometries=new Geometries();
    }

    /**
     * @param background, set the background color of the scene
     * @return the scene
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     * @param ambientLight, set the ambient Light  of the scene
     * @return the scene
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     * @param geometries, set the geometries of the scene
     * @return the scene
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
    /**
     * @param lights, set the lights of the scene
     * @return the scene
     */

    public Scene setLights(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }


}
