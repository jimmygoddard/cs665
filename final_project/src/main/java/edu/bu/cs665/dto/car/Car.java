package edu.bu.cs665.dto.car;

import edu.bu.cs665.dto.car.options.Option;
import edu.bu.cs665.exceptions.InvalidCarException;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Car implements Cloneable {
  private final UUID serialNumber = UUID.randomUUID();
  private CarType carType;
  private String color;
  private List<Option> options;
  private boolean isPurchased = false;

  private Car(final CarType carType, final String color) {
    this.carType = carType;
    this.color = color;
  }

  public UUID getSerialNumber() {
    return serialNumber;
  }

  public CarType getCarType() {
    return carType;
  }

  public void setCarType(final CarType carType) {
    this.carType = carType;
  }

  public String getColor() {
    return color;
  }

  public void setColor(final String color) {
    this.color = color;
  }

  public List<Option> getOptions() {
    return options;
  }

  public void setOptions(final List<Option> options) {
    this.options = options;
  }

  public double getBasePrice() throws InvalidCarException {
    return carType.getBasePrice();
  }

  public boolean isPurchased() {
    return isPurchased;
  }

  public void isPurchased(final boolean isPurchased) {
    this.isPurchased = isPurchased;
  }

  public void setPurchased(final boolean purchased) {
    isPurchased = purchased;
  }

  public static void vacuum(final Car car) {
    System.out.println("vacuuming car " + car);
  }

  public static void wash(final Car car) {
    System.out.println("washing car " + car);
  }

  public static void adjustSeats(final Car car) {
    System.out.println("adjusting seats for car " + car);
  }

  public static void refuel(final Car car) {
    System.out.println("refueling car " + car);
  }

  public static void optimizeTirePressure(final Car car) {
    System.out.println("optimizing tire pressure on car " + car);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    final Car car = (Car) o;
    return isPurchased == car.isPurchased
        && Objects.equals(serialNumber, car.serialNumber)
        && Objects.equals(carType, car.carType)
        && Objects.equals(color, car.color)
        && Objects.equals(options, car.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNumber, carType, color, options, isPurchased);
  }

  @Override
  public String toString() {
    final StringJoiner stringJoiner =
        new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
            .add("serialNumber=" + serialNumber)
            .add("carType=" + carType)
            .add("color='" + color + "'")
            .add("options=" + options)
            .add("isPurchased=" + isPurchased);
    final double basePrice;
    try {
      basePrice = getBasePrice();
      stringJoiner.add("basePrice=$" + basePrice);
    } catch (final InvalidCarException ignore) {
    }
    return stringJoiner.toString();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    final Car oldCar = (Car) super.clone();
    return new Car.CarBuilder()
        .setCarType((CarType) oldCar.getCarType().clone())
        .setColor(oldCar.getColor())
        .createCar();
  }

  public static class CarBuilder {

    private CarType carType;
    private String color = "black";

    public CarBuilder setCarType(final CarType carType) {
      this.carType = carType;
      return this;
    }

    public CarBuilder setColor(final String color) {
      this.color = color;
      return this;
    }

    public Car createCar() {
      return new Car(carType, color);
    }
  }
}
