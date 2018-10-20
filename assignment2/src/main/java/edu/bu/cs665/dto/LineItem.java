package edu.bu.cs665.dto;

public class LineItem implements Payable {

  private String description;
  private int quantity = 0;
  private double rate = 0;
  private double balance = 0;

  public LineItem() {}

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
}
