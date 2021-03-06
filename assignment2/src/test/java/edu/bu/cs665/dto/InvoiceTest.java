package edu.bu.cs665.dto;

import edu.bu.cs665.util.TestDataGenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {

  /** Test that the whole balance is paid for an invoice */
  @Test
  public void payBalanceFullBalanceTest() {
    final Invoice invoice = TestDataGenerator.generateTestInvoice();
    final double actualChange = invoice.payBalance(TestDataGenerator.TOTAL_BALANCE);
    Assert.assertEquals(0, actualChange, .001);
    Assert.assertEquals(0, invoice.getBalance(), .001);
  }

  /** Test that a partial balance is correctly paid for */
  @Test
  public void payBalancePartialBalanceTest() {
    final Invoice invoice = TestDataGenerator.generateTestInvoice();
    final int payment = (int) (TestDataGenerator.TOTAL_BALANCE / 2);
    final double actualChange = invoice.payBalance(payment);
    Assert.assertEquals(0, actualChange, .001);
    Assert.assertEquals(TestDataGenerator.TOTAL_BALANCE - payment, invoice.getBalance(), .001);
  }

  /**
   * Test that when more than the needed amount of money is used to pay an invoice the proper amount
   * of change is returned
   */
  @Test
  public void payBalancePayHigherThanBalanceTest() {
    final Invoice invoice = TestDataGenerator.generateTestInvoice();
    final int payment = (int) (TestDataGenerator.TOTAL_BALANCE * 2);
    final double actualChange = invoice.payBalance(payment);
    Assert.assertEquals(payment - TestDataGenerator.TOTAL_BALANCE, actualChange, .001);
    Assert.assertEquals(0, invoice.getBalance(), .001);
  }
}
