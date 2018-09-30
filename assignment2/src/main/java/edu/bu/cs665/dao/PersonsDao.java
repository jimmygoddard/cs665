package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface PersonsDao {

  void addEmployee(Employee employee);

  void updateEmployee(int id, Employee employee);

  void deleteEmployee(int id);

  List<Employee> getEmployees();

}
