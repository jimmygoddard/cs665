package edu.bu.cs665.dao;

import edu.bu.cs665.dto.Customer;
import java.util.List;

public interface CustomerStore {

  List<Customer> getCustomers();

  void setCustomers(List<Customer> customers);
}
