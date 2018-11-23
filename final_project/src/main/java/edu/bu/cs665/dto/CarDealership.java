package edu.bu.cs665.dto;

import edu.bu.cs665.dto.car.Car;
import java.util.List;
import java.util.UUID;

public interface CarDealership {
  List<Car> getCars();

  Car purchaseCar(UUID serialNumber);
}
