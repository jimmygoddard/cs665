package edu.bu.cs665.dto.car;

import edu.bu.cs665.exceptions.InvalidCarMake;
import java.util.Objects;

public class CarType {
  private CarModel carModel;
  private String carMake;
  private final int year = 2018;

  public CarModel getCarModel() {
    return carModel;
  }

  public void setCarModel(final CarModel carModel) {
    this.carModel = carModel;
  }

  public String getCarMake() {
    return carMake;
  }

  public void setCarMake(final String carMake) throws InvalidCarMake {
    if (this.carModel == null) {
      throw new InvalidCarMake("Must set car model before setting car make");
    } else if (!this.carModel.getMakes().contains(carMake)) {
      throw new InvalidCarMake(
          "Car make, " + carMake + ", is not available for car model, " + carModel);
    }
    this.carMake = carMake;
  }

  public int getYear() {
    return year;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarType)) {
      return false;
    }
    final CarType carType = (CarType) o;
    return Objects.equals(carModel, carType.carModel) && Objects.equals(carMake, carType.carMake);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carModel, carMake, year);
  }

  @Override
  public String toString() {
    return "CarType{"
        + "carModel="
        + carModel
        + ", carMake='"
        + carMake
        + '\''
        + ", year="
        + year
        + '}';
  }
}
