package edu.bu.cs665.dto;

import edu.bu.cs665.dto.car.Car;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars implements Iterable<Car> {

  private final List<Car> cars;

  public Cars(final List<Car> cars) {
    this.cars = cars;
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
