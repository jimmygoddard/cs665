package edu.bu.cs665.dto;

import java.util.Objects;

public class Service implements Receivable {

  private final String description;
  private double cost;

  public Service(final String description, final double cost) {
    this.description = description;
    this.cost = cost;
  }

  public String getDescription() {
    return description;
  }

  public double getCost() {
    return cost;
  }

  private void setCost(final double cost) {
    this.cost = cost;
  }

  @Override
  public double getTotalCost() {
    return getCost();
  }

  @Override
  public double payForServices() {
    final double amount = getCost();
    setCost(0);
    return amount;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Service)) {
      return false;
    }
    final Service service = (Service) o;
    return Double.compare(service.getCost(), getCost()) == 0
        && Objects.equals(getDescription(), service.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDescription(), getCost());
  }

  @Override
  public String toString() {
    return "Service{" + "description='" + description + '\'' + ", cost=" + cost + '}';
  }
}
