package edu.bu.cs665.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer implements Receivable {

  private final String name;
  private final String address;
  private final List<Service> services = new ArrayList<>();

  public Customer(final String name, final String address) {
    this.name = name;
    this.address = address;
  }

  private List<Service> getServices() {
    return this.services;
  }

  public void addService(final Service service) {
    getServices().add(service);
  }

  @Override
  public double getTotalCost() {
    return getServices().stream().mapToDouble(Service::getTotalCost).sum();
  }

  @Override
  public double payForServices() {
    return getServices().stream().mapToDouble(Service::payForServices).sum();
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
    return Objects.equals(name, customer.name)
        && Objects.equals(address, customer.address)
        && Objects.equals(getServices(), customer.getServices());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, getServices());
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
        + ", services="
        + services
        + '}';
  }
}
