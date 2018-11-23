package edu.bu.cs665.dto;

import edu.bu.cs665.dao.CarGarage;
import edu.bu.cs665.dao.CarGarageImpl;
import edu.bu.cs665.dto.car.Car;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CarsByJimmy implements CarDealership {

  private final CarGarage garage = CarGarageImpl.getCarGarage();

  private CarsByJimmy() {}

  private static class Singleton {
    private static final CarDealership instance = new CarsByJimmy();
  }

  public static CarDealership getCarDealership() {
    return Singleton.instance;
  }

  @Override
  public List<Car> getCars() {
    return garage.getCars();
  }

  @Override
  public Car purchaseCar(final UUID serialNumber) {
    final Car purchasedCar =
        garage
            .getCars()
            .stream()
            .filter(car -> car.getSerialNumber().equals(serialNumber))
            .findFirst()
            .orElse(null);
    if (purchasedCar != null) {
      purchasedCar.isPurchased(true);
    }
    return purchasedCar;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarsByJimmy)) {
      return false;
    }
    final CarsByJimmy that = (CarsByJimmy) o;
    return Objects.equals(garage, that.garage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(garage);
  }

  @Override
  public String toString() {
    return "CarsByJimmy{" + "garage=" + garage + '}';
  }
}
