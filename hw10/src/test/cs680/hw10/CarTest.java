package cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarTest {

    private final Car carA = new Car("A", 2020, 30000, 18000);
    private final Car carB = new Car("B", 2018, 50000, 15000);
    private final Car carC = new Car("C", 2022, 20000, 22000);

    @Test
    public void testMileageComparator() {
        List<Car> cars = Arrays.asList(carA, carB, carC);
        Collections.sort(cars, new MileageComparator());

        assertEquals(carC, cars.get(0));  // lowest mileage
        assertEquals(carA, cars.get(1));
        assertEquals(carB, cars.get(2));  // highest mileage
    }

    @Test
    public void testPriceComparator() {
        List<Car> cars = Arrays.asList(carA, carB, carC);
        Collections.sort(cars, new PriceComparator());

        assertEquals(carB, cars.get(0));  // cheapest
        assertEquals(carA, cars.get(1));
        assertEquals(carC, cars.get(2));  // most expensive
    }

    @Test
    public void testYearComparator() {
        List<Car> cars = Arrays.asList(carA, carB, carC);
        Collections.sort(cars, new YearComparator());

        assertEquals(carC, cars.get(0));  // newest
        assertEquals(carA, cars.get(1));
        assertEquals(carB, cars.get(2));  // oldest
    }

    @Test
    public void testParetoDominance() {
        ParetoComparator pc = new ParetoComparator();

        // clearly dominated car: older, more miles, more expensive
        Car bad = new Car("Bad", 2010, 150000, 30000);

        assertTrue(pc.compare(carA, bad) < 0);  // carA dominates bad
        assertTrue(pc.compare(bad, carA) > 0);  // reverse

        // carA vs carC: tradeoffs (C newer but more expensive)
        int ac = pc.compare(carA, carC);
        int ca = pc.compare(carC, carA);
        assertEquals(0, ac);
        assertEquals(0, ca);
    }
}
