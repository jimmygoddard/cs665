package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Employee.EmployeeBuilder;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import edu.bu.cs665.util.EmployeeGenerator;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HRDaoImplTest {

  private static final String FIRST_NAME = "TEST";
  private final HRDao hrDao = HRDaoImpl.getHRDao();
  private final Persistence persistence = PersistenceImpl.getPersistence();

  @Before
  public void setUp() {
    persistence.setEmployees(EmployeeGenerator.generateEmployees(5));
  }

  /**
   * getHRDao singleton test
   *
   * <p>Test that only a single instance of hrDao can be retrieved
   */
  @Test
  public void getHRDao() {
    final HRDao instanceOne = HRDaoImpl.getHRDao();
    final HRDao instanceTwo = HRDaoImpl.getHRDao();
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
    final int originalSize = hrDao.getEmployees().size();
    hrDao.addEmployee(newEmployee);
    Assert.assertEquals(originalSize + 1, hrDao.getEmployees().size());
    Assert.assertTrue(
        hrDao
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
    final int idToUpdate = hrDao.getEmployees().get(0).getId();
    final int expectedSize = hrDao.getEmployees().size();
    final Employee updatedEmployee =
        new EmployeeBuilder().setFirstName(FIRST_NAME).setId(idToUpdate).createEmployee();
    Assert.assertFalse(
        hrDao
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getFirstName().equals(FIRST_NAME)));
    hrDao.updateEmployee(idToUpdate, updatedEmployee);
    final int actualSize = hrDao.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertTrue(
        hrDao
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
    final int expectedSize = hrDao.getEmployees().size() - 1;
    final int idToDelete = hrDao.getEmployees().get(0).getId();
    Assert.assertTrue(
        hrDao.getEmployees().stream().anyMatch(employee -> employee.getId() == idToDelete));
    hrDao.deleteEmployee(idToDelete);
    final int actualSize = hrDao.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertFalse(
        hrDao.getEmployees().stream().anyMatch(employee -> employee.getId() == idToDelete));
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
    final List<Employee> actualEmployees = hrDao.getEmployees();
    Assert.assertEquals(expectedEmployees, actualEmployees);
  }
}
