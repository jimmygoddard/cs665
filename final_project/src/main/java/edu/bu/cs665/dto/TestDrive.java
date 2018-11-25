package edu.bu.cs665.dto;

import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class TestDrive {

  private LocalDate date;
  private LocalTime time;
  private Car car;
  private Customer customer;

  public TestDrive(final Car car, final LocalDate date, final LocalTime time) {
    System.out.println("Scheduling test drive at " + date + " and " + time + " for " + car);
    this.car = car;
    this.date = date;
    this.time = time;
  }

  public void beginTestDrive() throws InvalidTestDriveException {
    if (this.car == null) {
      throw new InvalidTestDriveException("There must be a car to test drive");
    }
    Car.vacuum(car);
    Car.wash(car);
    Car.adjustSeats(car);
    Car.refuel(car);
    Car.optimizeTirePressure(car);
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(final LocalDate date) {
    this.date = date;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(final LocalTime time) {
    this.time = time;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(final Car car) {
    this.car = car;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(final Customer customer) {
    this.customer = customer;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TestDrive)) {
      return false;
    }
    final TestDrive testDrive = (TestDrive) o;
    return Objects.equals(date, testDrive.date)
        && Objects.equals(time, testDrive.time)
        && Objects.equals(car, testDrive.car)
        && Objects.equals(customer, testDrive.customer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, time, car, customer);
  }

  @Override
  public String toString() {
    return "TestDrive{"
        + "date="
        + date
        + ", time="
        + time
        + ", car="
        + car
        + ", customer="
        + customer
        + '}';
  }
}
