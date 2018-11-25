package edu.bu.cs665.service;

import edu.bu.cs665.dao.CarGarage;
import edu.bu.cs665.dao.CarGarageImpl;
import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.TestDrive;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.dto.car.options.Option;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarsByJimmy implements CarDealership {

  private final CarGarage garage = CarGarageImpl.getCarGarage();

  private CarsByJimmy() {}

  private static class Singleton {
    private static final CarDealership instance = new CarsByJimmy();
  }

  public static CarDealership getCarDealership() {
    return Singleton.instance;
  }

  private Car getCarById(final UUID serialNumber) {
    return garage
        .getCars()
        .stream()
        .filter(car -> car.getSerialNumber().equals(serialNumber))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Cars getCars() {
    return new Cars(garage.getCars());
  }

  @Override
  public RedCars getRedCars() {
    return new RedCars(garage.getCars());
  }

  @Override
  public Car purchaseCar(final UUID serialNumber) {
    final Car car = getCarById(serialNumber);
    if (car != null) {
      car.isPurchased(true);
    }
    return car;
  }

  @Override
  public List<Car> getPurchasedCars() {
    return garage.getCars().stream().filter(Car::isPurchased).collect(Collectors.toList());
  }

  @Override
  public void setCars(final List<Car> cars) {
    garage.setCars(cars);
  }

  @Override
  public void testDrive(final String id, final LocalDate date, final LocalTime time)
      throws InvalidTestDriveException {
    final Car testDriveCar =
        garage
            .getCars()
            .stream()
            .filter(car -> car.getSerialNumber().toString().equals(id))
            .findFirst()
            .orElseThrow(() -> new InvalidTestDriveException("No car with serial number " + id));
    final TestDrive testDrive = new TestDrive(testDriveCar, date, time);
    testDrive.beginTestDrive();
  }

  @Override
  public Car addOptionsToCar(final UUID serialNumber, final List<Option> options) {
    final Car car = getCarById(serialNumber);
    car.setOptions(options);
    return car;
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
