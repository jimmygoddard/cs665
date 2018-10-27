package edu.bu.cs665.util;

import edu.bu.cs665.dto.Vendor;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.fluttercode.datafactory.impl.DataFactory;

public class VendorGenerator {

  private static final DataFactory dataFactory = new DataFactory();

  public static Vendor generateVendor() {
    final Vendor vendor = new Vendor(dataFactory.getName(), dataFactory.getAddress());
    for (int i = 0; i < dataFactory.getNumberBetween(1, 10); ++i) {
      vendor.addOrder(EmployeeGenerator.generateInvoice());
    }
    return vendor;
  }

  public static List<Vendor> generateVendors(int numVendors) {
    return IntStream.rangeClosed(1, numVendors)
        .mapToObj(i -> generateVendor())
        .collect(Collectors.toList());
  }
}
