package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VectorTest {
    /**
     * test constryctor {@link Vector#Vector(double, double, double)}
     */
    Vector v1 = new Vector(1.0D, 2.0D, 3.0D);
    Vector v2 = new Vector(-2.0D, -4.0D, -6.0D);
    Vector v3 = new Vector(0.0D, 3.0D, -2.0D);
    Vector v = new Vector(1.0D, 2.0D, 3.0D);
    Vector u = v.normalize();
    @Test
    void testConstructerNotZero() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Vector(0, 0, 0.0000000000000000000000000034);
                },
                "Vector(0,0,0) should have thrown Exception");
    }

    @Test
    /**
     * method for testing {@link Vector#lengthSquared()}
     */
    void testLengthSquared() {
        assertEquals(14.000000001,
                v1.lengthSquared(),
                0.000001,
                "ERROR: lengthSquared() wrong value");

    }

    @Test
    void testLength()
    {
        assertTrue(Util.isZero((new Vector(0.0D, 3.0D, 4.0D)).length() - 5.0D),"ERROR: length() wrong value");
    }

    @Test
    void testDotProduct()
    {
        assertTrue(Util.isZero(v1.dotProduct(v3)), "ERROR: dotProduct() for orthogonal vectors is not zero");

    assertTrue((Util.isZero(v1.dotProduct(v2) + 28.0D)),"ERROR: dotProduct() wrong value");

    }

    @Test
    void testCrossProduct() {
        Vector vr = v1.crossProduct(v3);
        assertTrue(Util.isZero(vr.length() - v1.length() * v3.length()),"ERROR: crossProduct() wrong result length");

        try {
            v1.crossProduct(v2);
            System.out.println("ERROR: crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception var9) {
        }
        assertTrue(Util.isZero(vr.length() - v1.length() * v3.length()),"ERROR: crossProduct() wrong result length");

        assertTrue(Util.isZero(vr.dotProduct(v1)) || !Util.isZero(vr.dotProduct(v3)),"ERROR: crossProduct() result is not orthogonal to its operands");
    }

    @Test
    void testNormalize()
    {
        assertTrue(v.dotProduct(u) < 0.0D,"ERROR: the normalized vector is opposite to the original one");
        Vector v = new Vector(1.0D, 2.0D, 3.0D);
        Vector u = v.normalize();
        assertTrue(Util.isZero(u.length() - 1.0D),
            "ERROR: the normalized vector is not a unit vector");

        try {
            v.crossProduct(u);
            System.out.println("ERROR: the normalized vector is not parallel to the original one");
        } catch (Exception var8) {
        }

        assertTrue((v.dotProduct(u) < 0.0D),
            "ERROR: the normalized vector is opposite to the original one");
    }

    @Test
    void testScale()
    {
        Point p1 = new Point(1.0D, 2.0D, 3.0D);
        assertTrue((p1.add(new Vector(-1.0D, -2.0D, -3.0D)).equals(new Point(0.0D, 0.0D, 0.0D))),
            "ERROR: Point + Vector does not work correctly");

        assertTrue(((new Vector(1.0D, 1.0D, 1.0D)).equals((new Point(2.0D, 3.0D, 4.0D)).subtract(p1)))
            ,"ERROR: Point - Point does not work correctly");
        }
    }