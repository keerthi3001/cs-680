package cs680.hw10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class CarTest {

    // Same sign behavior as Integer.compare
    private int expectedSignByInt(int a, int b) {
        return Integer.compare(a, b);
    }

    // Reusable helper: comparator should match getter's ordering
    private void assertComparatorMatchesGetterOrder(
            Comparator<Car> comp, Car c1, Car c2, int v1, int v2) {
        assertEquals(expectedSignByInt(v1, v2), comp.compare(c1, c2));
    }

    @Test
    public void yearComparatorMatchesYearGetter() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Honda", 2015, 35, 18000);

        Comparator<Car> comp = new YearComparator();
        assertComparatorMatchesGetterOrder(comp, c1, c2, c1.getYear(), c2.getYear());
    }

    @Test
    public void priceComparatorMatchesPriceGetter() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Honda", 2015, 35, 18000);

        Comparator<Car> comp = new PriceComparator();
        assertComparatorMatchesGetterOrder(comp, c1, c2, c1.getPrice(), c2.getPrice());
    }

    @Test
    public void mileageComparatorMatchesMileageGetter() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Honda", 2015, 35, 18000);

        Comparator<Car> comp = new MileageComparator();
        assertComparatorMatchesGetterOrder(comp, c1, c2, c1.getMileage(), c2.getMileage());
    }

    @Test
    public void paretoComparatorEqualObjectsReturnZero() {
        Car c1 = new Car("Toyota", 2010, 30, 20000);
        Car c2 = new Car("Toyota", 2010, 30, 20000);

        Comparator<Car> comp = new ParetoComparator();
        assertEquals(0, comp.compare(c1, c2));
    }

    @Test
    public void paretoComparatorDominatesWhenAllNonWorseAndOneStrictBetter() {
        // Dominance rule we assume for this HW:
        // year: higher is better
        // mileage: higher is better
        // price: lower is better
        // If c1 is not worse in all and strictly better in at least one => +1

        Car c1 = new Car("A", 2018, 35, 18000); // newer, higher mileage, cheaper
        Car c2 = new Car("B", 2016, 30, 20000); // older, lower mileage, more expensive

        Comparator<Car> comp = new ParetoComparator();
        assertEquals(1, comp.compare(c1, c2));
    }

    @Test
    public void paretoComparatorTradeoffReturnsZero() {
        // tradeoff: better in one metric but worse in another => 0

        Car c1 = new Car("A", 2018, 35, 22000); // better year+mileage, worse price
        Car c2 = new Car("B", 2020, 30, 18000); // better year+price, worse mileage

        Comparator<Car> comp = new ParetoComparator();
        assertEquals(0, comp.compare(c1, c2));
    }
}
