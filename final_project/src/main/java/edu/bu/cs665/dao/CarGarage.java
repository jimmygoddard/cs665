package edu.bu.cs665.dao;

import edu.bu.cs665.dto.car.Car;
import java.util.List;

public interface CarGarage {

  List<Car> getCars();

  void setCars(List<Car> cars);

  void addCars(List<Car> cars);
}
