package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.*;
import primitives.Vector;
import geometries.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SphereTest {
    /**
     * Test method for {@link geometries.Sphere#getNormal(Point)} (primitives.Point)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Sphere sph = new Sphere( new Point(0, 0, 1),1.0);
        assertEquals(new Vector(0, 0, 1), sph.getNormal(new Point(0, 0, 2)), "Bad normal to sphere");
    }

    /**
     * Test method for {@link geometries.Sphere#findIntersectionpoints(Ray)} (primitives.Ray)}.
     */
    @Test
    public void findIntersectionpoints() {
        Sphere sphere = new Sphere(new Point(1, 0, 0), 1d);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertEquals( null,sphere.findIntersectionpoints(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),"Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);
        List<Point> result1 = sphere.findIntersectionpoints(new Ray(new Point(-1, 0, 0), new Vector(3, 1, 0)));
        assertEquals( 2, result1.size(),"Wrong number of points");
        if (result1.get(0).get_x()> result1.get(1).get_y())
            result1 = Arrays.asList(result1.get(1), result1.get(0));
        assertEquals( Arrays.asList(p1, p2),Arrays.asList(result1.get(0), result1.get(1)),"Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)
        Point p3 = new Point(1.8867496997597595, 0.4622498999199199, 0);
        List<Point> result2 = sphere.findIntersectionpoints(new Ray(new Point(1d/2, 0, 0), new Vector(3, 1, 0)));
        assertEquals( 1, result2.size(),"Wrong number of points");
        assertEquals( p3, result2.get(0),"Ray inside sphere");

        // TC04: Ray starts after the sphere (0 points)
        List<Point> result3 = sphere.findIntersectionpoints(new Ray(new Point(2.5, 0, 0), new Vector(3, 1, 0)));
        assertEquals(null, result3,"Ray after sphere");

        // =============== Boundary Values Tests ==================

        // ** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        Point p4 = new Point(1.7999999999999998, 0.6, 0);
        List<Point> result4 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(3, 1, 0)));
        assertEquals( 1, result4.size(),"Wrong number of points");
        assertEquals(p4, result4.get(0),"Ray starts at sphere and goes inside");

        // TC12: Ray starts at sphere and goes outside (0 points)
        List<Point> result5 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(-3, 1, 0)));
        assertEquals( null, result5,"Ray starts at sphere and goes outside");

        // ** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        Point p5 = new Point(0, 0, 0);
        Point p6 = new Point(2, 0, 0);
        List<Point> result6 = sphere.findIntersectionpoints(new Ray(new Point(-2, 0, 0), new Vector(3, 0, 0)));
        assertEquals( 2, result6.size(),"Wrong number of points");
        if (result6.get(0).get_x() > result6.get(1).get_z())
            result6 = Arrays.asList(result6.get(1), result6.get(0));
        assertEquals( Arrays.asList(p5, p6), Arrays.asList(result6.get(0), result6.get(1)),"Ray starts before sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        Point p7 = new Point(2, 0, 0);
        List<Point> result7 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(3, 0, 0)));
        assertEquals( 1, result7.size(),"Wrong number of points");
        assertEquals( p7, result7.get(0),"Ray starts at sphere and goes inside");

        // TC15: Ray starts inside (1 points)
        Point p8 = new Point(2, 0, 0);
        List<Point> result8 = sphere.findIntersectionpoints(new Ray(new Point(1d/2, 0, 0), new Vector(3, 0, 0)));
        assertEquals( 1, result8.size(),"Wrong number of points");
        assertEquals( p8, result8.get(0),"Ray starts inside");

        // TC16: Ray starts at the center (1 points)
        Point p9 = new Point(2, 0, 0);
        List<Point> result9 = sphere.findIntersectionpoints(new Ray(new Point(1, 0, 0), new Vector(3, 0, 0)));
        assertEquals(1, result9.size(),"Wrong number of points");
        assertEquals(p9, result9.get(0),"Ray starts at the center");

        // TC17: Ray starts at sphere and goes outside (0 points)
        List<Point> result10 = sphere.findIntersectionpoints(new Ray(new Point(2, 0, 0), new Vector(3, 0, 0)));
        assertEquals( null, result10,"Ray starts at sphere and goes outside");

        // TC18: Ray starts after sphere (0 points)
        List<Point> result11 = sphere.findIntersectionpoints(new Ray(new Point(3, 0, 0), new Vector(7, 0, 0)));
        assertEquals(null, result11,"Ray starts after sphere");

        // ** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        Point p12 = new Point(0, 0, 0);
        List<Point> result12 = sphere.findIntersectionpoints(new Ray(new Point(0, -4, 0), new Vector(0, 3, 0)));
        assertEquals( 1, result12.size(),"Wrong number of points");
        assertEquals(p12, result12.get(0),"Ray starts before the tangent point");

        // TC20: Ray starts at the tangent point(0 points)
        List<Point> result13 = sphere.findIntersectionpoints(new Ray(new Point(0, 0, 0), new Vector(0, 3, 0)));
        assertEquals(null, result13,"Ray starts at the tangent point");

        // TC21: Ray starts after the tangent point(0 points)
        List<Point> result14 = sphere.findIntersectionpoints(new Ray(new Point(0, 1, 0), new Vector(0, 3, 0)));
        assertEquals(null, result14,"Ray starts after the tangent point");

        // ** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line(0 points)
        List<Point> result15 = sphere.findIntersectionpoints(new Ray(new Point(-1, 0, 0), new Vector(0, 3, 0)));
        assertEquals( null, result15,"Ray's line is outside, ray is orthogonal to ray start to sphere's center line");
    }
}