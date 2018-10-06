package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Employee.EmployeeBuilder;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import edu.bu.cs665.util.EmployeeGenerator;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonsDaoImplTest {

  private static final String FIRST_NAME = "TEST";
  private final PersonsDao personsDao = PersonsDaoImpl.getPersonsDao();
  private final Persistence persistence = PersistenceImpl.getPersistence();

  @Before
  public void setUp() {
    persistence.setEmployees(EmployeeGenerator.generateEmployees(5));
  }

  /**
   * getPersonsDao singleton test
   *
   * <p>Test that only a single instance of PersonsDao can be retrieved
   */
  @Test
  public void getPersonsDao() {
    final PersonsDao instanceOne = PersonsDaoImpl.getPersonsDao();
    final PersonsDao instanceTwo = PersonsDaoImpl.getPersonsDao();
    Assert.assertSame(instanceOne, instanceTwo);
  }

  /**
   * addEmployee test:
   *
   * <p>1) Verify that the employee does not already exist in the persistence layer
   *
   * <p>2) Add a new employee
   *
   * <p>3) Verify that the employee was added as expected
   */
  @Test
  public void addEmployee() {
    final Employee newEmployee = EmployeeGenerator.generateEmployee();
    final int originalSize = personsDao.getEmployees().size();
    personsDao.addEmployee(newEmployee);
    Assert.assertEquals(originalSize + 1, personsDao.getEmployees().size());
    Assert.assertTrue(
        personsDao
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getId() == newEmployee.getId()));
  }

  /**
   * updateEmployee test:
   *
   * <p>1) Retrieve the id of an employee to update
   *
   * <p>2) Create a new employee to be used for the update
   *
   * <p>3) Verify that the updated employee fields are not currently present in the persisted
   * employees
   *
   * <p>4) Update the employee
   *
   * <p>5) Verify that the updated fields are present in the persisted employees
   *
   * @throws EmployeeNotFoundException thrown by the updateEmployee method
   */
  @Test
  public void updateEmployee() throws EmployeeNotFoundException {
    final int idToUpdate = personsDao.getEmployees().get(0).getId();
    final int expectedSize = personsDao.getEmployees().size();
    final Employee updatedEmployee =
        new EmployeeBuilder().setFirstName(FIRST_NAME).setId(idToUpdate).createEmployee();
    Assert.assertFalse(
        personsDao
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getFirstName().equals(FIRST_NAME)));
    personsDao.updateEmployee(idToUpdate, updatedEmployee);
    final int actualSize = personsDao.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertTrue(
        personsDao
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getFirstName().equals(FIRST_NAME)));
  }

  /**
   * deleteEmployee test:
   *
   * <p>1) Determine the id of the employee to delete
   *
   * <p>2) Take a measure of the size of the employees stored before deletion
   *
   * <p>3) Delete the employee
   *
   * <p>4) Verify that no employee with the deleted employee's id exists in the employee storage
   *
   * <p>5) Verify that the number of stored employees decreases as expected
   *
   * @throws EmployeeNotFoundException
   */
  @Test
  public void deleteEmployee() throws EmployeeNotFoundException {
    final int expectedSize = personsDao.getEmployees().size() - 1;
    final int idToDelete = personsDao.getEmployees().get(0).getId();
    Assert.assertTrue(
        personsDao.getEmployees().stream().anyMatch(employee -> employee.getId() == idToDelete));
    personsDao.deleteEmployee(idToDelete);
    final int actualSize = personsDao.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertFalse(
        personsDao.getEmployees().stream().anyMatch(employee -> employee.getId() == idToDelete));
  }

  /**
   * getEmployees test:
   *
   * <p>1) Retrieve the list of employees from the persistence layer
   *
   * <p>2) Retrieve the list of employees from the dao layer
   *
   * <p>3) Verify that the two lists of employees are the same
   */
  @Test
  public void getEmployees() {
    final List<Employee> expectedEmployees = persistence.getEmployees();
    final List<Employee> actualEmployees = personsDao.getEmployees();
    Assert.assertEquals(expectedEmployees, actualEmployees);
  }
}
