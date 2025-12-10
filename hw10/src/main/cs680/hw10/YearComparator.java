package cs680.hw10;

import java.util.Comparator;

// Newer year is better
public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c2.getYear(), c1.getYear()); // newer first
    }
}
