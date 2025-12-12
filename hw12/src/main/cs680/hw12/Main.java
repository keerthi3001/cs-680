package cs680.hw12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota", "Corolla", 2018, 45000, 14000.0));
        cars.add(new Car("Honda", "Civic",   2020, 30000, 19000.0));
        cars.add(new Car("Tesla", "Model 3", 2022, 15000, 35000.0));
        cars.add(new Car("Ford",  "Focus",   2016, 60000, 10000.0));

        System.out.println("Original list:");
        cars.forEach(System.out::println);

        // 1) Sort by price (ascending) using a simple lambda
        cars.sort((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
        System.out.println("\nSorted by price (ascending, lambda):");
        cars.forEach(System.out::println);

        // 2) Sort by year (newer cars last → ascending year)
        cars.sort((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear()));
        System.out.println("\nSorted by year (ascending, lambda):");
        cars.forEach(System.out::println);

        // 3) Sort by mileage (ascending) using Comparator.comparing (still lambda-style)
        cars.sort(Comparator.comparing(Car::getMileage));
        System.out.println("\nSorted by mileage (ascending, method reference):");
        cars.forEach(System.out::println);

        // 4) Sort by model name (alphabetical) with a lambda
        cars.sort((c1, c2) -> c1.getModel().compareToIgnoreCase(c2.getModel()));
        System.out.println("\nSorted by model (A → Z, lambda):");
        cars.forEach(System.out::println);

        // 5) Example: “Pareto-like” – sort by price ascending, then mileage ascending
        cars.sort(
            Comparator.comparing(Car::getPrice)
                      .thenComparing(Car::getMileage)
        );
        System.out.println("\nSorted by price, then mileage (combined comparator):");
        cars.forEach(System.out::println);
    }
}
