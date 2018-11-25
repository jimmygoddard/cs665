package edu.bu.cs665.dto.car;

import edu.bu.cs665.exceptions.InvalidCarException;
import java.util.Objects;
import java.util.StringJoiner;

public class CarType implements Cloneable {
  private CarModel carModel;
  private String carMake;
  private final int year = 2018;

  public CarType(final CarModel carModel, final String carMake) {
    this.carModel = carModel;
    this.carMake = carMake;
  }

  public CarModel getCarModel() {
    return carModel;
  }

  public void setCarModel(final CarModel carModel) {
    this.carModel = carModel;
  }

  public String getCarMake() {
    return carMake;
  }

  public void setCarMake(final String carMake) throws InvalidCarException {
    if (carModel == null) {
      throw new InvalidCarException("Must set car model before setting car make");
    } else if (!this.carModel.getMakes().contains(carMake)) {
      throw new InvalidCarException(
          "Car make, " + carMake + ", is not available for car model, " + carModel);
    }
    this.carMake = carMake;
  }

  public int getYear() {
    return year;
  }

  public double getBasePrice() throws InvalidCarException {
    if (carModel == null) {
      throw new InvalidCarException("Car must have a model to have a price");
    } else if (carMake == null) {
      throw new InvalidCarException("Car must have a make to have a price");
    }
    return carModel.getBasePrice(carMake);
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
    return new StringJoiner(", ", CarType.class.getSimpleName() + "[", "]")
        .add("carModel=" + carModel)
        .add("carMake='" + carMake + "'")
        .add("year=" + year)
        .toString();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    final CarType oldType = (CarType) super.clone();
    return new CarType(oldType.getCarModel(), oldType.getCarMake());
  }
}
