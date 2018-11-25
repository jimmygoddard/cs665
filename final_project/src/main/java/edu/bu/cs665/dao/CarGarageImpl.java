package edu.bu.cs665.dao;

import edu.bu.cs665.dto.car.Car;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarGarageImpl implements CarGarage {

  private List<Car> cars = Collections.emptyList();

  private CarGarageImpl() {}

  private static class CarGarageImplHolder {
    private static final CarGarage instance = new CarGarageImpl();
  }

  public static CarGarage getCarGarage() {
    return CarGarageImplHolder.instance;
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
    if (!(o instanceof CarGarageImpl)) {
      return false;
    }
    final CarGarageImpl carGarage = (CarGarageImpl) o;
    return Objects.equals(cars, carGarage.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }

  @Override
  public String toString() {
    return "CarGarageImpl{" + "cars=" + cars + '}';
  }
}
