package cs680.hw10;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        if (c1 == null || c2 == null) {
            throw new NullPointerException("Car is null");
        }

        // Define "better" directions:
        // year: higher is better
        // mileage: higher is better
        // price: lower is better

        boolean c1NoWorse =
                c1.getYear() >= c2.getYear() &&
                c1.getMileage() >= c2.getMileage() &&
                c1.getPrice() <= c2.getPrice();

        boolean c1StrictBetter =
                c1.getYear() > c2.getYear() ||
                c1.getMileage() > c2.getMileage() ||
                c1.getPrice() < c2.getPrice();

        if (c1NoWorse && c1StrictBetter) {
            return 1;   // c1 dominates c2
        }

        boolean c2NoWorse =
                c2.getYear() >= c1.getYear() &&
                c2.getMileage() >= c1.getMileage() &&
                c2.getPrice() <= c1.getPrice();

        boolean c2StrictBetter =
                c2.getYear() > c1.getYear() ||
                c2.getMileage() > c1.getMileage() ||
                c2.getPrice() < c1.getPrice();

        if (c2NoWorse && c2StrictBetter) {
            return -1;  // c2 dominates c1
        }

        return 0; // equal OR tradeoff
    }
}
