package edu.bu.cs665.dto.car;

import java.util.List;

public interface CarModel {

  /**
   * Get the valid makes of a particular car model
   *
   * @return the valid makes of a particular car model
   */
  List<String> getMakes();

  /**
   * Get the base price of a specific make of car
   *
   * @param carMake the car make of which the price will be given
   * @return the base price of this particular make of this particular model
   */
  double getBasePrice(String carMake);
}
