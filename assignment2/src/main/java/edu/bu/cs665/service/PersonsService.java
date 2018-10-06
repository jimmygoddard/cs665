package edu.bu.cs665.service;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import java.util.List;

public interface PersonsService {

  /**
   * Add a new employee
   *
   * @param employee employee to add
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

  /**
   * Get a single Employee by id
   *
   * @param id id of the employee to retrieve
   * @return the Employee with the given id
   * @throws EmployeeNotFoundException if an Employee with id does not exist
   */
  Employee getEmployee(int id) throws EmployeeNotFoundException;

  /**
   * Retrieve all employees who reside in the US
   *
   * @return the list of employees who reside in the US
   */
  List<Employee> getEmployeesFromUS();

  /**
   * Retrieve all employees who do not reside in the US
   *
   * @return the list of employees who do not reside in the US
   */
  List<Employee> getEmployeesNotInUS();

  /**
   * Retrieve all male employees
   *
   * @return the list of male employees
   */
  List<Employee> getMaleEmployees();

  /**
   * Retrieve all female employees
   *
   * @return the list of female employees
   */
  List<Employee> getFemaleEmployees();

  /**
   * Calculate the tenure for an employee
   *
   * @param employee employee for which the tenure should be calculated
   * @return the tenure in days of the employee
   */
  long getTenureInDaysForEmployee(Employee employee);
}
