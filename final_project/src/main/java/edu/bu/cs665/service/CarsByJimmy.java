package edu.bu.cs665.service;

import edu.bu.cs665.dao.CarGarage;
import edu.bu.cs665.dao.CarGarageForJimmy;
import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.TestDrive;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.dto.car.options.DetailedPaintJob;
import edu.bu.cs665.dto.car.options.ElectricEngine;
import edu.bu.cs665.dto.car.options.GasEngine;
import edu.bu.cs665.dto.car.options.Hyrdaulics;
import edu.bu.cs665.dto.car.options.LeatherInterior;
import edu.bu.cs665.dto.car.options.MoonRoof;
import edu.bu.cs665.dto.car.options.Option;
import edu.bu.cs665.dto.car.options.PerformanceEngine;
import edu.bu.cs665.dto.car.options.Turbo;
import edu.bu.cs665.dto.car.options.UpgradeTires;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarsByJimmy implements CarDealership {

  private final CarGarage garage = CarGarageForJimmy.getCarGarage();

  private final List<Option> options =
      Arrays.asList(
          new DetailedPaintJob(),
          new ElectricEngine(),
          new GasEngine(),
          new Hyrdaulics(),
          new LeatherInterior(),
          new MoonRoof(),
          new PerformanceEngine(),
          new UpgradeTires(),
          new Turbo());

  private CarsByJimmy() {}

  private static class Singleton {
    private static final CarDealership instance = new CarsByJimmy();
  }

  public static CarDealership getCarDealership() {
    return Singleton.instance;
  }

  private Car getCarById(final String serialNumber) {
    return garage
        .getCars()
        .stream()
        .filter(car -> car.getSerialNumber().equals(UUID.fromString(serialNumber)))
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
  public Car purchaseCar(final String serialNumber) {
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
  public List<String> getOptionNames() {
    return options.stream().map(Option::getOptionName).collect(Collectors.toList());
  }

  @Override
  public Car addOptionsToCar(final String serialNumber, final List<String> optionNames) {
    final List<Option> packages =
        optionNames
            .stream()
            .map(
                name ->
                    options
                        .stream()
                        .filter(option -> option.getOptionName().equals(name))
                        .findFirst()
                        .orElse(null))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

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
    return new StringJoiner(", ", "Cars By Jimmy [", "]").add("garage=" + garage).toString();
  }
}
