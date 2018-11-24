package edu.bu.cs665.dto;

import java.util.Objects;
import java.util.UUID;
import org.fluttercode.datafactory.impl.DataFactory;

public class Customer {

  private final UUID id = UUID.randomUUID();
  private String name;
  private String address;
  private String emailAddress;
  private final DataFactory dataFactory = new DataFactory();

  public Customer() {
    name = dataFactory.getName();
    address = dataFactory.getAddress();
    emailAddress = dataFactory.getEmailAddress();
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(final String emailAddress) {
    this.emailAddress = emailAddress;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customer)) {
      return false;
    }
    final Customer customer = (Customer) o;
    return Objects.equals(id, customer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Customer{"
        + "name='"
        + name
        + '\''
        + ", address='"
        + address
        + '\''
        + ", emailAddress='"
        + emailAddress
        + '\''
        + '}';
  }
}
