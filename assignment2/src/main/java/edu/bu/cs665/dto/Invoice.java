package edu.bu.cs665.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Invoice implements Payable {
  private static int ID = 0;

  private final int id;
  private LocalDate createdDate;
  private LocalDate dueDate;
  private String toAddress;
  private String fromAddress;
  private final List<LineItem> lineItems = new ArrayList<>();

  public Invoice() {
    this.id = ID++;
  }

  public Invoice(
      final LocalDate createdDate,
      final LocalDate dueDate,
      final String toAddress,
      final String fromAddress) {
    this();
    this.createdDate = createdDate;
    this.dueDate = dueDate;
    this.toAddress = toAddress;
    this.fromAddress = fromAddress;
  }

  public int getId() {
    return this.id;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public String getToAddress() {
    return toAddress;
  }

  public String getFromAddress() {
    return fromAddress;
  }

  public List<LineItem> getLineItems() {
    return lineItems;
  }

  public void addLineItem(final LineItem lineItem) {
    this.lineItems.add(lineItem);
  }

  @Override
  public double getBalance() {
    return getLineItems().stream().mapToDouble(LineItem::getBalance).sum();
  }

  @Override
  public double payBalance(double payment) {
    for (final LineItem lineItem : getLineItems()) {
      final double balance = lineItem.getBalance();
      if (balance > 0) {
        payment = lineItem.payBalance(payment);
        if (payment <= 0) { // payment was less than balance
          return 0;
        }
      }
    }
    return payment;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Invoice)) {
      return false;
    }
    final Invoice invoice = (Invoice) o;
    return getId() == invoice.getId()
        && Objects.equals(getCreatedDate(), invoice.getCreatedDate())
        && Objects.equals(getDueDate(), invoice.getDueDate())
        && Objects.equals(getToAddress(), invoice.getToAddress())
        && Objects.equals(getFromAddress(), invoice.getFromAddress())
        && Objects.equals(getLineItems(), invoice.getLineItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(), getCreatedDate(), getDueDate(), getToAddress(), getFromAddress(), getLineItems());
  }

  @Override
  public String toString() {
    return "Invoice{"
        + "id="
        + id
        + ", createdDate="
        + createdDate
        + ", dueDate="
        + dueDate
        + ", toAddress='"
        + toAddress
        + '\''
        + ", fromAddress='"
        + fromAddress
        + '\''
        + ", lineItems="
        + lineItems
        + '}';
  }
}
