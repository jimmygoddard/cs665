package edu.bu.cs665.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer implements Receivable {

  private String m_name;
  private String m_address;
  private String m_email;
  private final List<Service> m_services = new ArrayList<>();
  private CustomerStatus m_customerStatus;

  public Customer(final String name, final String address) {
    m_name = name;
    m_address = address;
  }

  public String getName() {
    return m_name;
  }

  public void setName(final String name) {
    m_name = name;
  }

  public String getAddress() {
    return m_address;
  }

  public void setAddress(final String address) {
    m_address = address;
  }

  public String getEmail() {
    return m_email;
  }

  public void setEmail(final String email) {
    m_email = email;
  }

  public CustomerStatus getCustomerStatus() {
    return m_customerStatus;
  }

  public void setCustomerStatus(final CustomerStatus customerStatus) {
    this.m_customerStatus = customerStatus;
  }

  private List<Service> getServices() {
    return m_services;
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
    return Objects.equals(m_name, customer.m_name)
        && Objects.equals(m_address, customer.m_address)
        && Objects.equals(m_email, customer.m_email)
        && Objects.equals(getServices(), customer.getServices());
  }

  @Override
  public int hashCode() {
    return Objects.hash(m_name, m_address, m_email, getServices());
  }

  @Override
  public String toString() {
    return "Customer{"
        + "name='"
        + m_name
        + '\''
        + ", address='"
        + m_address
        + '\''
        + ", email='"
        + m_email
        + '\''
        + ", services="
        + m_services
        + '}';
  }
}
