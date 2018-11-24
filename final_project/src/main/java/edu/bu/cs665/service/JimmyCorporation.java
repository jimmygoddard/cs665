package edu.bu.cs665.service;

import java.util.Objects;
import java.util.UUID;
import org.fluttercode.datafactory.impl.DataFactory;

public class JimmyCorporation implements Business {

  private final UUID id = UUID.randomUUID();
  private final DataFactory dataFactory = new DataFactory();
  private final String address = dataFactory.getAddress();
  private final String phoneNumber = dataFactory.getNumberText(10);
  private final CarDealership carDealership = CarsByJimmy.getCarDealership();

  private JimmyCorporation() {}

  private static class Singleton {
    private static final JimmyCorporation instance = new JimmyCorporation();
  }

  public static JimmyCorporation getCorporation() {
    return Singleton.instance;
  }

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getName() {
    return "Jimmy Corporation";
  }

  @Override
  public String getAddress() {
    return address;
  }

  @Override
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public CarDealership getCarDealership() {
    return carDealership;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JimmyCorporation)) {
      return false;
    }
    final JimmyCorporation that = (JimmyCorporation) o;
    return Objects.equals(id, that.id)
        && Objects.equals(address, that.address)
        && Objects.equals(phoneNumber, that.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, phoneNumber);
  }

  @Override
  public String toString() {
    return "JimmyCorporation{"
        + "address='"
        + address
        + '\''
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + '}';
  }
}
