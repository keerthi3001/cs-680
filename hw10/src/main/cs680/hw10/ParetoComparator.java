package cs680.hw10;

import java.util.Comparator;

/*
 * Pareto comparison on three attributes:
 *  - newer year is better
 *  - lower mileage is better
 *  - lower price is better
 *
 * compare(c1, c2) returns:
 *   < 0  if c1 dominates c2
 *   > 0  if c2 dominates c1
 *   0    otherwise (trade-offs / equal)
 */
public class ParetoComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        int better1 = 0;
        int better2 = 0;

        // year: higher is better
        if (c1.getYear() > c2.getYear()) {
            better1++;
        } else if (c1.getYear() < c2.getYear()) {
            better2++;
        }

        // mileage: lower is better
        if (c1.getMileage() < c2.getMileage()) {
            better1++;
        } else if (c1.getMileage() > c2.getMileage()) {
            better2++;
        }

        // price: lower is better
        if (c1.getPrice() < c2.getPrice()) {
            better1++;
        } else if (c1.getPrice() > c2.getPrice()) {
            better2++;
        }

        if (better1 > 0 && better2 == 0) {
            return -1;   // c1 dominates
        } else if (better2 > 0 && better1 == 0) {
            return 1;    // c2 dominates
        } else {
            return 0;    // neither dominates
        }
    }
}
