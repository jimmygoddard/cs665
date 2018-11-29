package edu.bu.cs665.service;

import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CarDealership {

  /**
   * Get all cars belonging to this car dealership
   *
   * @return all cars belonging to this car dealership
   */
  Cars getCars();

  /**
   * Get all cars belonging to this dealership which have been purchased
   *
   * @return all cars belonging to this dealership which have been purchased
   */
  List<Car> getPurchasedCars();

  /**
   * Set the cars which belong to this dealership
   *
   * @param cars cars to give to the car dealership
   */
  void setCars(List<Car> cars);

  /**
   * Get all cars belonging to this dealership which are red
   *
   * @return all cars belonging to this dealership which are red
   */
  RedCars getRedCars();

  /**
   * Purchase a particular car from this dealership
   *
   * @param serialNumber serial number of the car to purchase
   * @return car which was purchased
   */
  Car purchaseCar(String serialNumber);

  void testDrive(String id, LocalDate date, LocalTime time) throws InvalidTestDriveException;

  List<String> getOptionNames();

  Car addOptionsToCar(String serialNumber, List<String> options);
}
