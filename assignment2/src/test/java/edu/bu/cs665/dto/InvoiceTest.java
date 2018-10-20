package edu.bu.cs665.dto;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {

  @Test
  public void payBalance() {
    final Invoice foo = new Invoice(LocalDate.now(), LocalDate.now(), "to", "from");
    final LineItem lineItemOne = new LineItem("description", 1, 10.00);
    final LineItem lineItemTwo = new LineItem("description", 2, 12.00);
    final LineItem lineItemThree = new LineItem("description", 3, 15.00);
    // total = 79
    foo.addLineItem(lineItemOne);
    foo.addLineItem(lineItemTwo);
    foo.addLineItem(lineItemThree);
    final double actualChange = foo.payBalance(79);
    Assert.assertEquals(0, actualChange, .001);
  }
}
