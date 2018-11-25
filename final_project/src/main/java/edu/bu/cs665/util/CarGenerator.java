package edu.bu.cs665.util;

import edu.bu.cs665.dto.car.Acura;
import edu.bu.cs665.dto.car.Audi;
import edu.bu.cs665.dto.car.BMW;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.dto.car.CarType;
import edu.bu.cs665.dto.car.Dodge;
import edu.bu.cs665.dto.car.Ford;
import edu.bu.cs665.dto.car.Lexus;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.fluttercode.datafactory.impl.DataFactory;

public class CarGenerator {
  private static final DataFactory dataFactory = new DataFactory();
  private static final List<String> colors =
      Arrays.asList("blue", "red", "black", "white", "green", "yellow", "purple", "brown");

  private static final List<Car> acuras =
      new Acura()
          .getMakes()
          .stream()
          .map(make -> new CarType(new Acura(), make))
          .map(
              carType ->
                  new Car.CarBuilder()
                      .setCarType(carType)
                      .setColor(colors.get(dataFactory.getNumberUpTo(colors.size())))
                      .createCar())
          .collect(Collectors.toList());

  private static final List<Car> audis =
      new Audi()
          .getMakes()
          .stream()
          .map(make -> new CarType(new Audi(), make))
          .map(
              carType ->
                  new Car.CarBuilder()
                      .setCarType(carType)
                      .setColor(colors.get(dataFactory.getNumberUpTo(colors.size())))
                      .createCar())
          .collect(Collectors.toList());

  private static final List<Car> bmws =
      new BMW()
          .getMakes()
          .stream()
          .map(make -> new CarType(new BMW(), make))
          .map(
              carType ->
                  new Car.CarBuilder()
                      .setCarType(carType)
                      .setColor(colors.get(dataFactory.getNumberUpTo(colors.size())))
                      .createCar())
          .collect(Collectors.toList());

  private static final List<Car> dodges =
      new Dodge()
          .getMakes()
          .stream()
          .map(make -> new CarType(new Dodge(), make))
          .map(
              carType ->
                  new Car.CarBuilder()
                      .setCarType(carType)
                      .setColor(colors.get(dataFactory.getNumberUpTo(colors.size())))
                      .createCar())
          .collect(Collectors.toList());

  private static final List<Car> fords =
      new Ford()
          .getMakes()
          .stream()
          .map(make -> new CarType(new Ford(), make))
          .map(
              carType ->
                  new Car.CarBuilder()
                      .setCarType(carType)
                      .setColor(colors.get(dataFactory.getNumberUpTo(colors.size())))
                      .createCar())
          .collect(Collectors.toList());

  private static final List<Car> lexuses =
      new Lexus()
          .getMakes()
          .stream()
          .map(make -> new CarType(new Lexus(), make))
          .map(
              carType ->
                  new Car.CarBuilder()
                      .setCarType(carType)
                      .setColor(colors.get(dataFactory.getNumberUpTo(colors.size())))
                      .createCar())
          .collect(Collectors.toList());

  private static final List<List<Car>> allCars =
      Arrays.asList(acuras, audis, bmws, dodges, fords, lexuses);

  private CarGenerator() {}

  public static Car generateCar() throws CloneNotSupportedException {
    final List<Car> cars = allCars.get(dataFactory.getNumberUpTo(allCars.size()));
    return (Car) cars.get(dataFactory.getNumberUpTo(cars.size())).clone();
  }

  public static List<Car> generateCars(final int numCars) {
    return IntStream.rangeClosed(1, numCars)
        .mapToObj(
            i -> {
              try {
                return generateCar();
              } catch (CloneNotSupportedException e) {
                return null;
              }
            })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }
}
