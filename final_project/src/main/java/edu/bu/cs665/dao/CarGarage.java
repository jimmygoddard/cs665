package edu.bu.cs665.dao;

import edu.bu.cs665.dto.car.Car;
import java.util.List;

public interface CarGarage {

  /**
   * Retrieve all cars in garage
   *
   * @return all cars in garage
   */
  List<Car> getCars();
}
