package edu.bu.cs665.dao;

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
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarStore {
  private final Random random = new Random(123);
  private final List<String> colors =
      Arrays.asList("blue", "red", "black", "white", "green", "yellow", "purple", "brown");

  private List<Car> acuras;
  private List<Car> audis;
  private List<Car> bmws;
  private List<Car> dodges;
  private List<Car> fords;
  private List<Car> lexuses;
  private List<List<Car>> allCars;

  private final void setUpCarStore() {
    acuras =
        new Acura()
            .getMakes()
            .stream()
            .map(make -> new CarType(new Acura(), make))
            .map(
                carType ->
                    new Car.CarBuilder()
                        .setCarType(carType)
                        .setColor(colors.get(random.nextInt(colors.size())))
                        .createCar())
            .collect(Collectors.toList());

    audis =
        new Audi()
            .getMakes()
            .stream()
            .map(make -> new CarType(new Audi(), make))
            .map(
                carType ->
                    new Car.CarBuilder()
                        .setCarType(carType)
                        .setColor(colors.get(random.nextInt(colors.size())))
                        .createCar())
            .collect(Collectors.toList());

    bmws =
        new BMW()
            .getMakes()
            .stream()
            .map(make -> new CarType(new BMW(), make))
            .map(
                carType ->
                    new Car.CarBuilder()
                        .setCarType(carType)
                        .setColor(colors.get(random.nextInt(colors.size())))
                        .createCar())
            .collect(Collectors.toList());

    dodges =
        new Dodge()
            .getMakes()
            .stream()
            .map(make -> new CarType(new Dodge(), make))
            .map(
                carType ->
                    new Car.CarBuilder()
                        .setCarType(carType)
                        .setColor(colors.get(random.nextInt(colors.size())))
                        .createCar())
            .collect(Collectors.toList());

    fords =
        new Ford()
            .getMakes()
            .stream()
            .map(make -> new CarType(new Ford(), make))
            .map(
                carType ->
                    new Car.CarBuilder()
                        .setCarType(carType)
                        .setColor(colors.get(random.nextInt(colors.size())))
                        .createCar())
            .collect(Collectors.toList());

    lexuses =
        new Lexus()
            .getMakes()
            .stream()
            .map(make -> new CarType(new Lexus(), make))
            .map(
                carType ->
                    new Car.CarBuilder()
                        .setCarType(carType)
                        .setColor(colors.get(random.nextInt(colors.size())))
                        .createCar())
            .collect(Collectors.toList());

    allCars = Arrays.asList(acuras, audis, bmws, dodges, fords, lexuses);
  }

  public CarStore() {
    setUpCarStore();
  }

  private Car getRandomCar() throws CloneNotSupportedException {
    final List<Car> cars = allCars.get(random.nextInt(allCars.size()));
    return (Car) cars.get(random.nextInt(cars.size())).clone();
  }

  public List<Car> getRandomNumCars(final int numCars) {
    return IntStream.rangeClosed(1, numCars)
        .mapToObj(
            i -> {
              try {
                return getRandomCar();
              } catch (CloneNotSupportedException e) {
                return null;
              }
            })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }
}
