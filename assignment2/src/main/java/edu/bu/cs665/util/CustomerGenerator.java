package edu.bu.cs665.util;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.fluttercode.datafactory.impl.DataFactory;

public class CustomerGenerator {
  private static final DataFactory dataFactory = new DataFactory();

  private static final int id = 0;

  private static Service generateService() {
    return new Service(dataFactory.getRandomWord(), dataFactory.getNumberBetween(10_000, 100_000));
  }

  public static Customer generateCustomer() {
    final Customer customer = new Customer(dataFactory.getName(), dataFactory.getAddress());
    for (int i = 0; i < dataFactory.getNumberBetween(1, 10); ++i) {
      customer.addService(generateService());
    }
    return customer;
  }

  public static List<Customer> generateCustomers(int numCustomers) {
    return IntStream.rangeClosed(1, numCustomers)
        .mapToObj(i -> generateCustomer())
        .collect(Collectors.toList());
  }
}
