package edu.bu.cs665.dto.car;

import edu.bu.cs665.dto.Option;
import java.util.List;
import java.util.UUID;

public class Car {
  private UUID serialNumber;
  private CarType carType;
  private String color;
  private List<Option> options;
  private double basePrice;
  private boolean isPurchased;


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

  public void setPurchased(boolean purchased) {
    isPurchased = purchased;
  }

  public void vacuum() {}
  public void wash() {}
  public void adjustSeats() {}
  public void refuel() {}
  public void optimizeTirePressure() {}


}
