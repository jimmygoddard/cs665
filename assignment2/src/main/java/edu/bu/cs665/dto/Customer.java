package edu.bu.cs665.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer implements Receivable {

  private String name;
  private String address;
  private String email;
  private final List<Service> services = new ArrayList<>();
  private CustomerStatus customerStatus;
  private String rejectedSalesReason;

  public Customer(final String name, final String address) {
    this.name = name;
    this.address = address;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public CustomerStatus getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(final CustomerStatus customerStatus) {
    this.customerStatus = customerStatus;
  }

  private List<Service> getServices() {
    return services;
  }

  public void addService(final Service service) {
    getServices().add(service);
  }

  public String getRejectedSalesReason() {
    return rejectedSalesReason;
  }

  public void setRejectedSalesReason(String rejectedSalesReason) {
    this.rejectedSalesReason = rejectedSalesReason;
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
        && Objects.equals(email, customer.email)
        && Objects.equals(getServices(), customer.getServices());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, email, getServices());
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
        + ", email='"
        + email
        + '\''
        + ", services="
        + services
        + '}';
  }
}
