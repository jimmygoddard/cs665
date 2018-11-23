package edu.bu.cs665.dto;

import edu.bu.cs665.dto.car.Car;
import java.util.List;
import java.util.UUID;

public class CarsByJimmy implements Business, CarDealership {

  private UUID id;
  private String name;
  private String address;
  private String phoneNumber;
  private List<Car> cars;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getAddress() {
    return address;
  }

  @Override
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public List<Car> getCars() {
    return cars;
  }

  @Override
  public void purchaseCar(UUID serialNumber) {

  }
}
