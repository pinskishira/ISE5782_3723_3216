package unittests.miniProjectFinal;

import geometries.Geometry;
import geometries.*;
import lighting.AmbientLight;
import lighting.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import renderer.*;
import scene.Scene;
import java.awt.color.*;

import static java.awt.Color.*;

public class PictureTest {
    Scene scene = new Scene("New Picture");
    @Test
    public void BonusImage() {
        Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0))
                .setVPSize(200, 200).setVPDistance(1000).setNumOfRays(81);

        scene.setAmbientLight(new AmbientLight(new Color(BLACK), new Double3(0.3)));

        scene.geometries.add(
                new Plane(new Point(-150, -150, -100), new Point(-100, 100, -100), new Point(75, 75, -100))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(20)).setEmission(new Color(blue)),

                //The mother chick head
                new Sphere(new Point(-30, -35, 5), 20) //
                        .setEmission(new Color(yellow)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //mother chick body
                new Sphere(new Point(-30, -80, 5), 30) //
                        .setEmission(new Color(yellow)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),

                //Mother chick's eyes
                new Sphere(new Point(-20, -25, 85), 4) //
                        .setEmission(new Color(black)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),

                //Mother chick's beak
                new Triangle(new Point(-10, -35, 70), new Point(-10, -30, 70), new Point(3, -32.5, 70))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(255,69,0)),

                //First baby chick head
                new Sphere(new Point(20, -70, 5), 10) //
                        .setEmission(new Color(yellow)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //first baby chick body
                new Sphere(new Point(20, -90, 5), 15) //
                        .setEmission(new Color(yellow)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),

                //First baby chick's eyes
                new Sphere(new Point(22, -60, 85), 2) //
                        .setEmission(new Color(black)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),

                //First baby chick's beak
                new Triangle(new Point(28, -68, 70), new Point(28, -65, 70), new Point(35, -67.5, 70))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(255,69,0)),

                //Second baby chick head
                new Sphere(new Point(50, -70, 5), 10) //
                        .setEmission(new Color(yellow)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //second baby chick body
                new Sphere(new Point(50, -90, 5), 15) //
                        .setEmission(new Color(yellow)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),

                //Second baby chick's eyes
                new Sphere(new Point(50, -60, 85), 2) //
                        .setEmission(new Color(black)) //
                        .setMaterial(new Material().setKd(0.2).setKs(0.2).setShininess(50).setKT(0.1)),

                //Second baby chick's beak
                new Triangle(new Point(56, -68, 70), new Point(56, -65, 70), new Point(63, -67.5, 70))
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(255,69,0)),

                //for the cloud
                new Sphere(new Point(-20, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-17, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-22, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-15, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-12, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-17, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-5, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(0, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-10, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-5, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(0, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-10, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-30, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-27, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-32, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-30, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-27, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-32, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-40, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-37, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-42, 65, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-40, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-37, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-42, 70, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-25, 80, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-22, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-27, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //for the cloud
                new Sphere(new Point(-25, 80, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-22, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                new Sphere(new Point(-27, 75, 5), 5) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),
                //a bigger sphere for the cloud
                new Sphere(new Point(-20, 80, 5), 10) //
                        .setEmission(new Color(white)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.00001)),

                //The kite
                new Triangle(new Point(20, 30, 50), new Point(40, 30, 50), new Point(40, 58, 50)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(pink)),
                new Triangle(new Point(40, 58, 50), new Point(40, 30, 50), new Point(60, 30, 50)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(red)),
                new Triangle(new Point(20, 30, 50), new Point(40, 30, 50), new Point(40, 2, 50)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(red)),
                new Triangle(new Point(40, 2, 50), new Point(40, 30, 50), new Point(60, 30, 50)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(pink)),

                new Triangle(new Point(40, 2, 50), new Point(35, 5, 50), new Point(35, -1, 50)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(orange)),
                new Triangle(new Point(40, 2, 50), new Point(45, 5, 50), new Point(45, -1, 50)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(50).setKT(0.25)).setEmission(new Color(orange)),

                //The sun
                new Sphere(new Point(-90, 80, 60), 40) //
                        .setEmission(new Color(YELLOW)) //
                        .setMaterial(new Material().setKd(0.8).setKs(0.8).setShininess(50).setKT(0.65)),

        //The grass
        new Triangle(new Point(-100,-100,42), new Point(-95,-80,42), new Point(-90,-100,42))
                .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(GREEN)), //
                new Triangle(new Point(-90,-100,42), new Point(-85,-80,42), new Point(-80,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),//
                new Triangle(new Point(-80,-100,42), new Point(-75,-80,42), new Point(-70,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.3)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-70,-100,42), new Point(-65,-80,42), new Point(-60,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-60,-100,42), new Point(-55,-80,42), new Point(-50,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-50,-100,42), new Point(-45,-80,42), new Point(-40,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-40,-100,42), new Point(-35,-80,42), new Point(-30,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-30,-100,42), new Point(-25,-80,42), new Point(-20,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-20,-100,42), new Point(-15,-80,42), new Point(-10,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(-10,-100,42), new Point(-5,-80,42), new Point(0,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(0,-100,42), new Point(5,-80,42), new Point(10,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(10,-100,42), new Point(15,-80,42), new Point(20,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(20,-100,42), new Point(25,-80,42), new Point(30,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.2)).setEmission(new Color(GREEN)),
                new Triangle(new Point(30,-100,42), new Point(35,-80,42), new Point(40,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.15)).setEmission(new Color(GREEN)),
                new Triangle(new Point(40,-100,42), new Point(45,-80,42), new Point(50,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.2)).setEmission(new Color(GREEN)),
                new Triangle(new Point(50,-100,42), new Point(55,-80,42), new Point(60,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(60,-100,42), new Point(65,-80,42), new Point(70,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(70,-100,42), new Point(75,-80,42), new Point(80,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(80,-100,42), new Point(85,-80,42), new Point(90,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN)),
                new Triangle(new Point(90,-100,42), new Point(95,-80,42), new Point(100,-100,42)) //
                        .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(60).setKT(0.25)).setEmission(new Color(GREEN))
        );


        scene.lights.add(new SpotLight(new Color(700, 400, 400), new Point(-90, 80, 5), new Vector(0, 10, 5)) //
                .setKl(0.0001).setKq(0.0005));
        scene.lights.add(new PointLight(new Color(white), new Point(-90, 80, 5)) //
                .setKl(0.000000000001).setKq(0.0000000000005));


        ImageWriter imageWriter = new ImageWriter("Final image", 600, 600);

        camera.setImageWriter(imageWriter) //
                .setRayTracer(new RayTracerBasic(scene)).renderImage().setNumOfRays(81); //
        camera.writeToImage();; //
    }
}