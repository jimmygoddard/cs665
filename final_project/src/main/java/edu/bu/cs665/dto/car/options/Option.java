package edu.bu.cs665.dto.car.options;

import java.util.UUID;

public interface Option {

  /**
   * Get the id of the option
   *
   * @return the id of the option
   */
  UUID getId();

  /**
   * Get the name of the option
   *
   * @return the name of the option
   */
  String getOptionName();

  /**
   * Get the description of the option
   *
   * @return the description of the option
   */
  String getOptionDescription();

  /**
   * Get the price of the option
   *
   * @return the price of the option
   */
  double getOptionPrice();

  /**
   * Get the time it takes to install the option
   *
   * @return the time it takes to install the option
   */
  double getTimeToInstall();
}
