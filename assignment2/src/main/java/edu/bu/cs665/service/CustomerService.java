package edu.bu.cs665.service;

import edu.bu.cs665.dto.Customer;
import java.util.List;

public interface CustomerService {

  List<Customer> getCustomers();

  void setCustomers(List<Customer> customers);

  void addCustomers(List<Customer> customers);
}
