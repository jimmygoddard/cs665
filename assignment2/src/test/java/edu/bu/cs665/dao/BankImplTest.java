package edu.bu.cs665.dao;

import edu.bu.cs665.exception.BalanceExceededException;
import org.junit.Assert;
import org.junit.Test;

public class BankImplTest {

  private final Bank bank = BankImpl.getBank();

  /** Test that the BankImpl class returns the same instance every time */
  @Test
  public void getBank() {
    final Bank instanceOne = BankImpl.getBank();
    final Bank instanceTwo = BankImpl.getBank();
    Assert.assertSame(instanceOne, instanceTwo);
  }

  /** Test that the bank balance changes accordingly when money is deposited */
  @Test
  public void deposit() {
    final double originalBalance = bank.getBalance();
    bank.deposit(1);
    Assert.assertEquals(originalBalance + 1, bank.getBalance(), .001);
  }

  /**
   * Test that the bank balance changes accordingly when money is withdrawn
   *
   * @throws BalanceExceededException thrown by withdrawal when the withdraw amount exceeds the bank
   *     balance
   */
  @Test
  public void withdrawal() throws BalanceExceededException {
    final double originalBalance = bank.getBalance();
    bank.withdrawal(1);
    Assert.assertEquals(originalBalance - 1, bank.getBalance(), .001);
  }
}
