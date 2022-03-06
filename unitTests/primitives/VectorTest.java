package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    /**
     * test constryctor {@link Vector#Vector(double, double, double)}
     */
    Vector v1 = new Vector(1.0D, 2.0D, 3.0D);
    Vector v2 = new Vector(-2.0D, -4.0D, -6.0D);
    Vector v3 = new Vector(0.0D, 3.0D, -2.0D);
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
        assertEquals(14.000000001,v1.lengthSquared(),0.000001,"ERROR: lengthSquared() wrong value");

    }

    @Test
    void testLength() {
    }

    @Test
    void testDotProduct() {
    }

    @Test
    void testCrossProduct() {
    }

    @Test
    void testNormalize() {
    }

    @Test
    void testScale() {
    }
}