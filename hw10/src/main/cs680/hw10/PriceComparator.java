package cs680.hw10;

import java.util.Comparator;

// Lower price is better
public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.getPrice(), c2.getPrice());
    }
}
