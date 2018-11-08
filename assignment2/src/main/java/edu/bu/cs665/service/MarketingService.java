package edu.bu.cs665.service;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import java.util.List;

public interface MarketingService {

  void emailCustomers(List<Customer> customers);

  List<Vendor> getPartners();

  List<Customer> getPotentialCustomers();

  List<Customer> getCurrentCustomers();

  List<Customer> getInProgressCustomers();
}
