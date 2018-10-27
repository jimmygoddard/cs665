package edu.bu.cs665.dao;

import edu.bu.cs665.exception.BalanceExceededException;

public class BankImpl implements Bank {

  private double balance = 10_000_000.00;

  private BankImpl() {}

  private static class BankImplHolder {
    private static final Bank instance = new BankImpl();
  }

  public static Bank getBank() {
    return BankImplHolder.instance;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void deposit(final double amount) {
    this.balance += amount;
  }

  @Override
  public double withdrawal(final double amount) throws BalanceExceededException {
    if (amount > this.balance) {
      throw new BalanceExceededException(
          "Amount " + amount + " exceeds the current balance " + this.balance);
    }
    this.balance -= amount;
    return amount;
  }
}
