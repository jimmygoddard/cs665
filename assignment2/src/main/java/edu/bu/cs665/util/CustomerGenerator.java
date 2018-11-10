package edu.bu.cs665.util;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.CustomerStatus;
import edu.bu.cs665.dto.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.fluttercode.datafactory.impl.DataFactory;

public class CustomerGenerator {
  private static final DataFactory dataFactory = new DataFactory();

  private static Service generateService() {
    return new Service(dataFactory.getRandomWord(), dataFactory.getNumberBetween(10_000, 100_000));
  }

  private static Customer generateCustomer() {
    final Customer customer = new Customer(dataFactory.getName(), dataFactory.getAddress());
    customer.setCustomerStatus(
        CustomerStatus.values()[dataFactory.getNumberUpTo(CustomerStatus.values().length)]);
    customer.setEmail(dataFactory.getEmailAddress());
    if (customer.getCustomerStatus().equals(CustomerStatus.REJECTED)) {
      final StringBuilder rejectionReason = new StringBuilder();
      for (int i = 0; i < 5; ++i) {
        rejectionReason.append(dataFactory.getRandomWord()).append(" ");
      }
      customer.setRejectedSalesReason(rejectionReason.toString());
    }
    for (int i = 0; i < dataFactory.getNumberBetween(1, 10); ++i) {
      customer.addService(generateService());
    }
    return customer;
  }

  public static List<Customer> generateCustomers(final int numCustomers) {
    return IntStream.rangeClosed(1, numCustomers)
        .mapToObj(i -> generateCustomer())
        .collect(Collectors.toList());
  }
}
