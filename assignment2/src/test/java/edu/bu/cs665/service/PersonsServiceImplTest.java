package edu.bu.cs665.service;

import edu.bu.cs665.dao.Persistence;
import edu.bu.cs665.dao.PersistenceImpl;
import edu.bu.cs665.dto.persons.CitizenStatus;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Gender;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import edu.bu.cs665.util.EmployeeGenerator;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonsServiceImplTest {

  private static final String FIRST_NAME = "TEST";
  private static final int ID = 12345;
  private static final int TENURE = 10;
  private final PersonsService personsService = PersonsServiceImpl.getPersonsService();
  private final Persistence persistence = PersistenceImpl.getPersistence();

  @Before
  public void setUp() {
    persistence.setEmployees(EmployeeGenerator.generateEmployees(5));
  }

  /**
   * getPersonsService singleton test
   *
   * <p>Test that only a single instance of PersonsService can be retrieved
   */
  @Test
  public void getPersonsService() {
    final PersonsService instanceOne = PersonsServiceImpl.getPersonsService();
    final PersonsService instanceTwo = PersonsServiceImpl.getPersonsService();
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
    final int expectedSize = personsService.getEmployees().size() + 1;
    final Employee newEmployee =
        new Employee.EmployeeBuilder().setFirstName(FIRST_NAME).setId(ID).createEmployee();
    Assert.assertFalse(
        personsService
            .getEmployees()
            .stream()
            .anyMatch(
                employee -> employee.getId() == ID && employee.getFirstName().equals(FIRST_NAME)));
    personsService.addEmployee(newEmployee);
    final int actualSize = personsService.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertTrue(
        personsService
            .getEmployees()
            .stream()
            .anyMatch(
                employee -> employee.getId() == ID && employee.getFirstName().equals(FIRST_NAME)));
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
    final int idToUpdate = personsService.getEmployees().get(0).getId();
    final int expectedSize = personsService.getEmployees().size();
    final Employee updatedEmployee =
        new Employee.EmployeeBuilder().setFirstName(FIRST_NAME).setId(idToUpdate).createEmployee();
    Assert.assertFalse(
        personsService
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getFirstName().equals(FIRST_NAME)));
    personsService.updateEmployee(idToUpdate, updatedEmployee);
    final int actualSize = personsService.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertTrue(
        personsService
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
    final int expectedSize = personsService.getEmployees().size() - 1;
    final int idToDelete = personsService.getEmployees().get(0).getId();
    Assert.assertTrue(
        personsService
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getId() == idToDelete));
    personsService.deleteEmployee(idToDelete);
    final int actualSize = personsService.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertFalse(
        personsService
            .getEmployees()
            .stream()
            .anyMatch(employee -> employee.getId() == idToDelete));
  }

  /**
   * getEmployees test:
   *
   * <p>1) Retrieve the list of employees from the persistence layer
   *
   * <p>2) Retrieve the list of employees from the service layer
   *
   * <p>3) Verify that the two lists of employees are the same
   */
  @Test
  public void getEmployees() {
    final List<Employee> expectedEmployees = persistence.getEmployees();
    final List<Employee> actualEmployees = personsService.getEmployees();
    Assert.assertEquals(expectedEmployees, actualEmployees);
  }

  /**
   * getEmployeesNotInUS test:
   *
   * <p>1) Add one employee that is a US citizen
   *
   * <p>2) Add one employee that is not a US citizen
   *
   * <p>3) Verify that only the employee that is a US citizen is retrieved
   */
  @Test
  public void getEmployeesFromUS() {
    final Employee visa =
        new Employee.EmployeeBuilder().setCitizenStatus(CitizenStatus.VISA).createEmployee();
    final Employee citizen =
        new Employee.EmployeeBuilder().setCitizenStatus(CitizenStatus.CITIZEN).createEmployee();
    persistence.setEmployees(Arrays.asList(visa, citizen));
    final List<Employee> citizens = personsService.getEmployeesFromUS();
    Assert.assertEquals(Collections.singletonList(citizen), citizens);
  }

  /**
   * getEmployeesNotInUS test:
   *
   * <p>1) Add one employee that is a US citizen
   *
   * <p>2) Add one employee that is not a US citizen
   *
   * <p>3) Verify that only the employee that is not a US citizen is retrieved
   */
  @Test
  public void getEmployeesNotInUS() {
    final Employee visa =
        new Employee.EmployeeBuilder().setCitizenStatus(CitizenStatus.VISA).createEmployee();
    final Employee citizen =
        new Employee.EmployeeBuilder().setCitizenStatus(CitizenStatus.CITIZEN).createEmployee();
    persistence.setEmployees(Arrays.asList(visa, citizen));
    final List<Employee> visas = personsService.getEmployeesNotInUS();
    Assert.assertEquals(Collections.singletonList(visa), visas);
  }

  /**
   * getMaleEmployees test:
   *
   * <p>1) Add one employee that is male
   *
   * <p>2) Add one employee that is female
   *
   * <p>3) Verify that only the employee that is male is retrieved
   */
  @Test
  public void getMaleEmployees() {
    final Employee male = new Employee.EmployeeBuilder().setGender(Gender.MALE).createEmployee();
    final Employee female =
        new Employee.EmployeeBuilder().setGender(Gender.FEMALE).createEmployee();
    persistence.setEmployees(Arrays.asList(male, female));
    final List<Employee> males = personsService.getMaleEmployees();
    Assert.assertEquals(Collections.singletonList(male), males);
  }

  /**
   * getFemaleEmployees test:
   *
   * <p>1) Add one employee that is male
   *
   * <p>2) Add one employee that is female
   *
   * <p>3) Verify that only the employee that is female is retrieved
   */
  @Test
  public void getFemaleEmployees() {
    final Employee male = new Employee.EmployeeBuilder().setGender(Gender.MALE).createEmployee();
    final Employee female =
        new Employee.EmployeeBuilder().setGender(Gender.FEMALE).createEmployee();
    persistence.setEmployees(Arrays.asList(male, female));
    final List<Employee> females = personsService.getFemaleEmployees();
    Assert.assertEquals(Collections.singletonList(female), females);
  }

  /**
   * getTenureInDaysForEmployee test:
   *
   * <p>1) Create an employee with a known tenure
   *
   * <p>4) Verify that the calculated tenure is as expected
   */
  @Test
  public void getTenureInDaysForEmployee() {
    final Employee employee =
        new Employee.EmployeeBuilder()
            .setStartDate(LocalDate.now().minusDays(TENURE))
            .setId(ID)
            .createEmployee();
    final long actualTenure = personsService.getTenureInDaysForEmployee(employee);
    Assert.assertEquals(TENURE, actualTenure);
  }
}
