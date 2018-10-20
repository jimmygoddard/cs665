package edu.bu.cs665.dto;

public interface Payable {
  double getBalance();

  double payBalance(double payment);
}
