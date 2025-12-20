package cs680.hw10;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        // ascending by year (older -> newer)
        return Integer.compare(c1.getYear(), c2.getYear());
    }
}
