package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import java.util.List;

public interface PersonsDao {

  /**
   * Add a new employee to be persisted
   *
   * @param employee the new employee to add
   */
  void addEmployee(Employee employee);

  /**
   * Update an already existing employee
   *
   * @param id id of the already existing employee to update
   * @param employee the new employee object to replace the existing one with
   * @throws EmployeeNotFoundException if an Employee with id does not exist
   */
  void updateEmployee(int id, Employee employee) throws EmployeeNotFoundException;

  /**
   * Delete an employee
   *
   * @param id id of the employee to delete
   * @throws EmployeeNotFoundException if an Employee with id does not exist
   */
  void deleteEmployee(int id) throws EmployeeNotFoundException;

  /**
   * Retrieve the list of all employees
   *
   * @return list of all employees
   */
  List<Employee> getEmployees();
}
