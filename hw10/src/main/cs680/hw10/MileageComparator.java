package cs680.hw10;

import java.util.Comparator;

// Lower mileage is better
public class MileageComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.getMileage(), c2.getMileage());
    }
}
