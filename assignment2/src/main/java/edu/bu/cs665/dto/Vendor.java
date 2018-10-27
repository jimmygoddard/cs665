package edu.bu.cs665.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vendor implements Payable {

  private final String name;
  private final String address;
  private final List<Invoice> orders = new ArrayList<>();

  public Vendor(final String name, final String address) {
    this.name = name;
    this.address = address;
  }

  private List<Invoice> getOrders() {
    return orders;
  }

  public void addOrder(final Invoice order) {
    getOrders().add(order);
  }

  @Override
  public double getBalance() {
    return getOrders().stream().mapToDouble(Invoice::getBalance).sum();
  }

  @Override
  public double payBalance(double payment) {
    for (final Invoice expense : getOrders()) {
      final double balance = expense.getBalance();
      if (balance > 0) {
        payment = expense.payBalance(payment);
        if (payment <= 0) { // payment was less than balance
          return 0;
        }
      }
    }
    return payment;
  }

  @Override
  public String toString() {
    return "Vendor{"
        + "name='"
        + name
        + '\''
        + ", address='"
        + address
        + '\''
        + ", orders="
        + orders
        + '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Vendor)) {
      return false;
    }
    final Vendor vendor = (Vendor) o;
    return Objects.equals(name, vendor.name)
        && Objects.equals(address, vendor.address)
        && Objects.equals(getOrders(), vendor.getOrders());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, getOrders());
  }
}
