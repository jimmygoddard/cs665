package edu.bu.cs665.service;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface PersonsService {

  void addEmployee(Employee employee);

  void updateEmployee(int id, Employee employee);

  void deleteEmployee(int id);

  List<Employee> getEmployees();

  Employee getEmployee(int id);

  List<Employee> getEmployeesFromUS();

  List<Employee> getEmployeesNotInUS();

  List<Employee> getMaleEmployees();

  List<Employee> getFemaleEmployees();

  long getTenureInDaysForEmployee(Employee employee);
}
