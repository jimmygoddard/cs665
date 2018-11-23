package edu.bu.cs665.dto.car;

import edu.bu.cs665.dto.car.options.Option;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Car {
  private UUID serialNumber = UUID.randomUUID();
  private CarType carType;
  private String color;
  private List<Option> options;
  private double basePrice;
  private boolean isPurchased = false;

  private Car(CarType carType, String color, double basePrice) {
    this.carType = carType;
    this.color = color;
    this.basePrice = basePrice;
  }

  public UUID getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(UUID serialNumber) {
    this.serialNumber = serialNumber;
  }

  public CarType getCarType() {
    return carType;
  }

  public void setCarType(CarType carType) {
    this.carType = carType;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public List<Option> getOptions() {
    return options;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(double basePrice) {
    this.basePrice = basePrice;
  }

  public boolean isPurchased() {
    return isPurchased;
  }

  public void isPurchased(boolean isPurchased) {
    this.isPurchased = isPurchased;
  }

  public void setPurchased(boolean purchased) {
    isPurchased = purchased;
  }

  public void vacuum() {}

  public void wash() {}

  public void adjustSeats() {}

  public void refuel() {}

  public void optimizeTirePressure() {}

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    Car car = (Car) o;
    return Double.compare(car.basePrice, basePrice) == 0
        && isPurchased == car.isPurchased
        && Objects.equals(serialNumber, car.serialNumber)
        && Objects.equals(carType, car.carType)
        && Objects.equals(color, car.color)
        && Objects.equals(options, car.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNumber, carType, color, options, basePrice, isPurchased);
  }

  @Override
  public String toString() {
    return "Car{"
        + "serialNumber="
        + serialNumber
        + ", carType="
        + carType
        + ", color='"
        + color
        + '\''
        + ", options="
        + options
        + ", basePrice="
        + basePrice
        + ", isPurchased="
        + isPurchased
        + '}';
  }

  public static class CarBuilder {

    private CarType carType;
    private String color;
    private double basePrice;

    public CarBuilder setCarType(CarType carType) {
      this.carType = carType;
      return this;
    }

    public CarBuilder setColor(String color) {
      this.color = color;
      return this;
    }

    public CarBuilder setBasePrice(double basePrice) {
      this.basePrice = basePrice;
      return this;
    }

    public Car createCar() {
      return new Car(carType, color, basePrice);
    }
  }
}
