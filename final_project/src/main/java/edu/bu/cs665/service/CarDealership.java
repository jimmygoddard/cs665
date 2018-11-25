package edu.bu.cs665.service;

import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CarDealership {
  Cars getCars();

  List<Car> getPurchasedCars();

  void setCars(List<Car> cars);

  RedCars getRedCars();

  Car purchaseCar(String serialNumber);

  void testDrive(String id, LocalDate date, LocalTime time) throws InvalidTestDriveException;

  List<String> getOptionNames();

  Car addOptionsToCar(String serialNumber, List<String> options);
}
