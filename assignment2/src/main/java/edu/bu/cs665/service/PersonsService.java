package edu.bu.cs665.service;

import edu.bu.cs665.dto.persons.Employee;

public interface PersonsService {

  void addEmployee(Employee employee);

  void updateEmployee(int id, Employee employee);

  void deleteEmployee(int id);
}
