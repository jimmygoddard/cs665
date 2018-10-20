package edu.bu.cs665.util;

import edu.bu.cs665.dto.Invoice;
import edu.bu.cs665.dto.LineItem;
import java.time.LocalDate;

public class TestDataGenerator {

  private static final String DESCRIPTION = "description";
  private static final int LI_ONE_QUANTITY = 1;
  private static final int LI_TWO_QUANTITY = 2;
  private static final int LI_THREE_QUANTITY = 3;
  private static final double LI_ONE_RATE = 800.00;
  private static final double LI_TWO_RATE = 750.00;
  private static final double LI_THREE_RATE = 2_000.00;

  public static final double TOTAL_BALANCE =
      (LI_ONE_QUANTITY * LI_ONE_RATE)
          + (LI_TWO_QUANTITY * LI_TWO_RATE)
          + (LI_THREE_QUANTITY * LI_THREE_RATE);

  public static Invoice generateTestInvoice() {
    final Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now(), "to", "from");
    final LineItem lineItemOne = new LineItem(DESCRIPTION, LI_ONE_QUANTITY, LI_ONE_RATE);
    final LineItem lineItemTwo = new LineItem(DESCRIPTION, LI_TWO_QUANTITY, LI_TWO_RATE);
    final LineItem lineItemThree = new LineItem(DESCRIPTION, LI_THREE_QUANTITY, LI_THREE_RATE);
    invoice.addLineItem(lineItemOne);
    invoice.addLineItem(lineItemTwo);
    invoice.addLineItem(lineItemThree);
    return invoice;
  }
}
