package edu.bu.cs665.dao;

import edu.bu.cs665.exception.BalanceExceededException;

public interface Bank {
  double getBalance();

  void deposit(double amount);

  double withdrawal(double amount) throws BalanceExceededException;
}
