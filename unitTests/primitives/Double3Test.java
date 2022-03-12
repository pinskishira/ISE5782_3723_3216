package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Double3Test {
    @Test
    void testDistance() {

        Double3 point0 = new Double3(1, 1, -100);
        Double3 point1 = new Double3(-1, 1, -99);
        Double3 point2 = new Double3(0, 0, -100);
        Double3 point3 = new Double3(0.5, 0, -100);
        double resultsquared;
        double result;

        resultsquared = point3.distanceSquared(new Double3(0,0,-100));
        System.out.println(resultsquared);
        result = point3.distance(new Double3(0,0,-100));
        System.out.println(result);
    }
}