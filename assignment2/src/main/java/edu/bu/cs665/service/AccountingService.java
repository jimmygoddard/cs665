package edu.bu.cs665.service;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface AccountingService {

  void payExpenses(List<Employee> employees);

  void payVendors(List<Vendor> vendors);

  void receivePayments(List<Customer> customers);
}
