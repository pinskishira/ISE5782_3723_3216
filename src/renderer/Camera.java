package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import static primitives.Util.isZero;

public class Camera {
    /**
     * Camera's location.
     */
    private Point p0;
    /**
     * Camera's upper direction.
     */
    private Vector vUp;
    /**
     * Camera's forward direction.
     */
    private Vector vTo;
    /**
     * Camera's right direction
     */
    private Vector vRight;
    /**
     * View plane's width.
     */
    private double width;
    /**
     * View plane's height.
     */
    private double height;
    /**
     * The distance between the camera and the view plane.
     */
    private double distance;

    // Field for image writer
    private ImageWriter imageWriter;
    // Field for ray tracer
    private RayTracerBase rayTracer;
    private int numOfRays;

    /**
     * Returns the camera location.
     */
    public Point getP0() {
        return p0;
    }

    /**
     * Returns the camera's upper direction.
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * Returns the camera's forward direction.
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * Returns the camera's right direction.
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * Returns the view plane's width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the view plane's height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the distance between the camera and the view plane.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Setter of builder patterns
     * Set image writer
     *
     * @param ImageWriter parameter for imgaeWriter
     * @return Camera object
     */
    public Camera setImageWriter(ImageWriter ImageWriter) {
        this.imageWriter = ImageWriter;
        return this;
    }


    /**
     * Setter of builder patterns
     * set ray tracer
     * @param rayTracerBasic parameter for rayTracerBasic
     * @return Camera object
     */
    public Camera setRayTracer(RayTracerBasic rayTracerBasic) {
        this.rayTracer = rayTracerBasic;
        return this;
    }

    /**
     * Constructs a camera with location, to and up vectors.
     * The right vector is being calculated by the to and up vectors.
     *
     * @param p0  The camera's location.
     * @param vTo The direction to where the camera is looking.
     * @param vUp The direction of the camera's upper direction.
     * @throws IllegalArgumentException When to and up vectors aren't orthogonal.
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (!isZero(vTo.dotProduct(vUp))) {
            throw new IllegalArgumentException("Up vector is not Orthogonal with To vector");
        }
        this.p0 = p0;
        this.vTo = vTo.normalize();
        this.vUp = vUp.normalize();
        vRight = vTo.crossProduct(vUp);
    }

    /**
     * Chaining method for setting the view plane's size.
     *
     * @param width  The new view plane's width.
     * @param height The new view plane's height.
     * @return The camera itself.
     */
    public Camera setVPSize(double width, double height) {
        if (width <= 0) {

            throw new IllegalArgumentException("Illegal value of width");
        }
        this.width = width;
        if (height <= 0) {

            throw new IllegalArgumentException("Illegal value of width");
        }
        this.height = height;
        return this;
    }

    /**
     * Chaining method for setting the distance between the camera and the view plane.
     *
     * @param distance The new distance between the camera and the view plane.
     * @return The camera itself.
     * @throws IllegalArgumentException When distance illegal.
     */
    public Camera setVPDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Illegal value of distance");
        }

        this.distance = distance;
        return this;
    }



    /**
     * The function calculate the center point of the pixel.
     *
     * @param nX Total number of pixels in the x dimension.
     * @param nY Total number of pixels in the y dimension.
     * @param j  The index of the pixel on the x dimension.
     * @param i  The index of the pixel on the y dimension.
     * @return the center point in the pixel.
     */
    private Point CalculateCenterPointInPixel(int nX, int nY, int j, int i) {
        Point pC = p0.add(vTo.scale(distance));
        Point pIJ = pC;

        double rY = height / nY;
        double rX = width / nX;

        double yI = -(i - (nY - 1) / 2d) * rY;
        double xJ = (j - (nX - 1) / 2d) * rX;

        if (!isZero(xJ)) {
            pIJ = pIJ.add(vRight.scale(xJ));
        }
        if (!isZero(yI)) {
            pIJ = pIJ.add(vUp.scale(yI));
        }
        return pIJ;
    }


    /**
     * Constructs a ray through a given pixel on the view plane.
     *
     * @param nX Total number of pixels in the x dimension.
     * @param nY Total number of pixels in the y dimension.
     * @param j The index of the pixel on the x dimension.
     * @param i The index of the pixel on the y dimension.
     * @return
     */

    public Ray constructRay(int nX, int nY, int j, int i) {
        Point pCenterPixel = CalculateCenterPointInPixel(nX, nY, j, i);
        return new Ray(p0, pCenterPixel.subtract(p0));
    }

    public Camera renderImage() throws MissingResourceException, IllegalArgumentException
    {
        try {
            if (imageWriter == null) {
                throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
            }
            if (rayTracer == null) {
                throw new MissingResourceException("missing resource", RayTracerBase.class.getName(), "");
            }
            if (p0 == null){
                throw new MissingResourceException("missing resource", Point.class.getName(), "");
            }
            if (vUp == null  ||vRight == null || vTo == null){
                throw new MissingResourceException("missing resource", Vector.class.getName(), "");
            }

            //rendering the image
            int nX = imageWriter.getNx();
            int nY = imageWriter.getNy();
            for (int i = 0; i < nY; i++) {
                for (int j = 0; j < nX; j++) {
                    if(numOfRays == 1 || numOfRays == 0)
                    {
                        primitives.Color rayColor = castRay(imageWriter.getNx(), imageWriter.getNy(), j, i);
                        imageWriter.writePixel(j, i, rayColor);
                    }
                    else
                    {
                        List<Ray> rays = constructBeamThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i,numOfRays);
                        primitives.Color rayColor = rayTracer.traceRay(rays);
                        imageWriter.writePixel(j, i, rayColor);
                    }
//                    imageWriter.writePixel(j, i, castRay(nX, nY, j, i));
                }
            }
        } catch (MissingResourceException e) {
            throw new UnsupportedOperationException("Not implemented yet" + e.getClassName());
        }
        return this;
    }
    /**
     * function that get the color of each point in
     * the view plane and paint it .
     */
    /**public void renderImage() {
        // if one of the fields hasn't been initialized throw an exception
        if (imageWriter == null) {
            throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
        }
        if (rayTracer == null) {
            throw new MissingResourceException("missing resource", RayTracerBase.class.getName(), "");
        }

        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        //go over all the pixels
        for (int i = 0; i < nX; i++) {
            for (int j = 0; j < nY; j++) {
                // construct a ray through the current pixel
                Ray ray = this.constructRay(nX, nY, j, i);
                // get the  color of the point from trace ray
                Color color = rayTracer.traceRay(ray);
                // write the pixel color to the image
                imageWriter.writePixel(j, i, color);
            }
        }
    }*/

    /**
     * function that create the grid
     *
     * @param interval the interval between grids
     * @param color the color for the grid
     */
    public void printGrid(int interval, Color color) {
        // if imageWriter hasn't been initialized throw an exception
        if (imageWriter == null) {
            throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
        }

        imageWriter.printGrid(interval, color);
    }

    /**
     * Function renderImage produces unoptimized png file of the image according to
     * pixel color matrix in the directory of the project
     */
    public void writeToImage() {
        // if imageWriter hasn't been initialized throw an exception
        if (imageWriter == null) {
            throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
        }

        imageWriter.writeToImage();
    }

    public Camera setNumOfRays(int numOfRays)
    {
        if(numOfRays <= 0)
            this.numOfRays=1;
        else
            this.numOfRays = numOfRays;
        return this;
    }



    private primitives.Color castRay(int nX, int nY, int j, int i) {
        Ray ray = constructRay(nX, nY, j, i);
        primitives.Color pixelColor = rayTracer.traceRay(ray);
        return pixelColor;
    }

    /**
     *
     * @param nX the amount of horizontal pixels
     * @param nY the amount of vertical pixels
     * @param j the row of a pixel
     * @param i the column of a pixel
     * @param raysAmount
     * @return list of rays
     */
    public List<Ray> constructBeamThroughPixel (int nX, int nY, int j, int i, int raysAmount)
    {
        int numOfRays = (int)Math.floor(Math.sqrt(raysAmount)); //num of rays in each row or column
        if (numOfRays==1)
            return List.of(constructRay(nX, nY, j, i));
        //Ratio (pixel width & height)
        double Ry= height/nY;
        double Rx=width/nX;
        double Yi=(i-(nY-1)/2d)*Ry;
        double Xj=(j-(nX-1)/2d)*Rx;
        double PRy = Ry / numOfRays; //height distance between each ray
        double PRx = Rx / numOfRays; //width distance between each ray
        //The distance between the view plane and the camera cannot be 0
        if (isZero(distance))
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        List<Ray> sampleRays = new ArrayList<>();

        //for each pixel in the pixels grid
        for (int i1 = 0; i1 < numOfRays; ++i1)
        {
            for (int j1 = 0; j1< numOfRays; ++j1)
            {
                sampleRays.add(constructRaysThroughPixel(PRy,PRx,Yi, Xj, i1, j1));//add the ray
            }
        }
        sampleRays.add(constructRay(nX, nY, j, i));//add the center  ray to pixel
        return sampleRays;
    }

    /**
     * the function treats each pixel like a little screen of its own and divide it to smaller "pixels".
     * Through each one we construct a ray. This function is similar to ConstructRayThroughPixel.
     * @param Ry height of each grid block we divided the pixel into
     * @param Rx width of each grid block we divided the pixel into
     * @param yi distance of original pixel from (0,0) on Y axis
     * @param xj distance of original pixel from (0,0) on X axis
     * @param j j coordinate of small "pixel"
     * @param i i coordinate of small "pixel"
     * @return beam of rays through pixel
     */
    private Ray constructRaysThroughPixel(double Ry,double Rx, double yi, double xj, int j, int i)
    {
        Point Pc = p0.add(vTo.scale(distance)); //the center of the screen point

        double ySampleI =  (i *Ry + Ry/2d); //The pixel starting point on the y axis
        double xSampleJ=   (j *Rx + Rx/2d); //The pixel starting point on the x axis

        Point Pij = Pc; //The point at the pixel through which a beam is fired
        //Moving the point through which a beam is fired on the x axis
        if (!isZero(xSampleJ + xj))
        {
            Pij = Pij.add(vRight.scale(xSampleJ + xj));
        }
        //Moving the point through which a beam is fired on the y axis
        if (!isZero(ySampleI + yi))
        {
            Pij = Pij.add(vUp.scale(-ySampleI -yi ));
        }
        Vector Vij = Pij.subtract(p0);

        return new Ray(p0,Vij);//create the ray throw the point we calculate here
    }




}

