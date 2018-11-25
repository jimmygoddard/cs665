package edu.bu.cs665.dto;

import edu.bu.cs665.dto.car.Car;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RedCars implements Iterable<Car> {

  private final List<Car> cars;

  public RedCars(final List<Car> cars) {
    if (isEmpty(cars)) {
      this.cars = Collections.emptyList();
      return;
    }
    this.cars =
        cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("red"))
            .collect(Collectors.toList());
  }

  public boolean isEmpty() {
    return isEmpty(cars);
  }

  private static boolean isEmpty(final List<Car> cars) {
    return cars == null || cars.isEmpty();
  }

  @Override
  public Iterator<Car> iterator() {
    return new CarIterator();
  }

  private class CarIterator implements Iterator<Car> {

    private final int size = cars.size();
    private int currentPosition = 0;

    @Override
    public boolean hasNext() {
      return currentPosition < size;
    }

    @Override
    public Car next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return cars.get(currentPosition++);
    }
  }
}
