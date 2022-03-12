package geometries;

import org.junit.jupiter.api.Test;

class SphereTest {

    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Test ==============
    Sphere sp = new Sphere(new Point(0,0,0),1);
        assertEquals(new Vector(0,0, 1), sp.getNormal(new Point(0, 0, 1)));
    }
}