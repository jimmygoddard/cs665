package edu.bu.cs665.service;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface AccountingService {

  void payExpenses(List<Employee> employees);

}
