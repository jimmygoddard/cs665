package edu.bu.cs665.dto;

import java.util.Objects;

public class LineItem implements Payable {

  private String description;
  private int quantity = 0;
  private double rate = 0;
  private double balance = 0;

  public LineItem(final String description, final int quantity, final double rate) {
    this.description = description;
    setQuantity(quantity);
    setRate(rate);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(final int quantity) {
    this.quantity = quantity;
    setBalance();
  }

  public double getRate() {
    return rate;
  }

  public void setRate(final double rate) {
    this.rate = rate;
    setBalance();
  }

  private void setBalance() {
    this.balance = this.quantity * this.rate;
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

  @Override
  public double payBalance(final double payment) {
    if (payment > this.balance) {
      final double change = payment - this.balance;
      this.balance = 0;
      return change;
    }
    this.balance = this.balance - payment;
    return 0;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LineItem)) {
      return false;
    }
    final LineItem lineItem = (LineItem) o;
    return getQuantity() == lineItem.getQuantity()
        && Double.compare(lineItem.getRate(), getRate()) == 0
        && Double.compare(lineItem.getBalance(), getBalance()) == 0
        && Objects.equals(getDescription(), lineItem.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDescription(), getQuantity(), getRate(), getBalance());
  }

  @Override
  public String toString() {
    return "LineItem{"
        + "description='"
        + description
        + '\''
        + ", quantity="
        + quantity
        + ", rate="
        + rate
        + ", balance="
        + balance
        + '}';
  }
}
