package edu.bu.cs665.dao;

import edu.bu.cs665.exception.BalanceExceededException;
import org.junit.Assert;
import org.junit.Test;

public class BankImplTest {

  private final Bank m_bank = BankImpl.getBank();

  @Test
  public void getBank() {
    final Bank instanceOne = BankImpl.getBank();
    final Bank instanceTwo = BankImpl.getBank();
    Assert.assertSame(instanceOne, instanceTwo);
  }

  @Test
  public void deposit() {
    final double originalBalance = m_bank.getBalance();
    m_bank.deposit(1);
    Assert.assertEquals(originalBalance + 1, m_bank.getBalance(), .001);
  }

  @Test
  public void withdrawal() throws BalanceExceededException {
    final double originalBalance = m_bank.getBalance();
    m_bank.withdrawal(1);
    Assert.assertEquals(originalBalance - 1, m_bank.getBalance(), .001);
  }
}
