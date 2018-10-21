package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface PersonStore {

  /**
   * Retrieve employees from persistence
   *
   * @return all employees currently persisted
   */
  List<Employee> getEmployees();

  /**
   * Persist employees
   *
   * @param employees list of employees to persist
   */
  void setEmployees(List<Employee> employees);
}
