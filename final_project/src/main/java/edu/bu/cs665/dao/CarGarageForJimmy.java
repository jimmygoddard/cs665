package edu.bu.cs665.dao;

import edu.bu.cs665.dto.car.Car;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class CarGarageForJimmy implements CarGarage {

  private List<Car> cars = Collections.emptyList();

  private CarGarageForJimmy() {}

  private static class Singleton {
    private static final CarGarage instance = new CarGarageForJimmy();
  }

  public static CarGarage getCarGarage() {
    return Singleton.instance;
  }

  @Override
  public List<Car> getCars() {
    return cars;
  }

  @Override
  public void setCars(final List<Car> cars) {
    this.cars = cars;
  }

  @Override
  public void addCars(final List<Car> newCars) {
    cars.addAll(newCars);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarGarageForJimmy)) {
      return false;
    }
    final CarGarageForJimmy carGarage = (CarGarageForJimmy) o;
    return Objects.equals(cars, carGarage.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CarGarageForJimmy.class.getSimpleName() + "[", "]")
        .add("cars=" + cars)
        .toString();
  }
}
