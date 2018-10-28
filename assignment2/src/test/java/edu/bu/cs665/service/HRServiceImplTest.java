package edu.bu.cs665.service;

import edu.bu.cs665.dao.PersonStore;
import edu.bu.cs665.dao.PersonStoreImpl;
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

public class HRServiceImplTest {

  private static final String FIRST_NAME = "TEST";
  private static final int ID = 12345;
  private static final int TENURE = 10;
  private final HRService HRService = HRServiceImpl.getHRService();
  private final PersonStore personStore = PersonStoreImpl.getPersistence();

  @Before
  public void setUp() {
    personStore.setEmployees(EmployeeGenerator.generateEmployees(5));
  }

  /**
   * getHRService singleton test
   *
   * <p>Test that only a single instance of HRService can be retrieved
   */
  @Test
  public void getHRService() {
    final HRService instanceOne = HRServiceImpl.getHRService();
    final HRService instanceTwo = HRServiceImpl.getHRService();
    Assert.assertSame(instanceOne, instanceTwo);
  }

  /**
   * addEmployee test:
   *
   * <p>1) Verify that the employee does not already exist in the personStore layer
   *
   * <p>2) Add a new employee
   *
   * <p>3) Verify that the employee was added as expected
   */
  @Test
  public void addEmployee() {
    final int expectedSize = HRService.getEmployees().size() + 1;
    final Employee newEmployee =
        new Employee.EmployeeBuilder().setFirstName(FIRST_NAME).setId(ID).createEmployee();
    Assert.assertFalse(
        HRService.getEmployees()
            .stream()
            .anyMatch(
                employee -> employee.getId() == ID && employee.getFirstName().equals(FIRST_NAME)));
    HRService.addEmployee(newEmployee);
    final int actualSize = HRService.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertTrue(
        HRService.getEmployees()
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
    final int idToUpdate = HRService.getEmployees().get(0).getId();
    final int expectedSize = HRService.getEmployees().size();
    final Employee updatedEmployee =
        new Employee.EmployeeBuilder().setFirstName(FIRST_NAME).setId(idToUpdate).createEmployee();
    Assert.assertFalse(
        HRService.getEmployees()
            .stream()
            .anyMatch(employee -> employee.getFirstName().equals(FIRST_NAME)));
    HRService.updateEmployee(idToUpdate, updatedEmployee);
    final int actualSize = HRService.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertTrue(
        HRService.getEmployees()
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
    final int expectedSize = HRService.getEmployees().size() - 1;
    final int idToDelete = HRService.getEmployees().get(0).getId();
    Assert.assertTrue(
        HRService.getEmployees().stream().anyMatch(employee -> employee.getId() == idToDelete));
    HRService.deleteEmployee(idToDelete);
    final int actualSize = HRService.getEmployees().size();
    Assert.assertEquals(expectedSize, actualSize);
    Assert.assertFalse(
        HRService.getEmployees().stream().anyMatch(employee -> employee.getId() == idToDelete));
  }

  /**
   * getEmployees test:
   *
   * <p>1) Retrieve the list of employees from the personStore layer
   *
   * <p>2) Retrieve the list of employees from the service layer
   *
   * <p>3) Verify that the two lists of employees are the same
   */
  @Test
  public void getEmployees() {
    final List<Employee> expectedEmployees = personStore.getEmployees();
    final List<Employee> actualEmployees = HRService.getEmployees();
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
    personStore.setEmployees(Arrays.asList(visa, citizen));
    final List<Employee> citizens = HRService.getEmployeesFromUS();
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
    personStore.setEmployees(Arrays.asList(visa, citizen));
    final List<Employee> visas = HRService.getEmployeesNotInUS();
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
    personStore.setEmployees(Arrays.asList(male, female));
    final List<Employee> males = HRService.getMaleEmployees();
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
    personStore.setEmployees(Arrays.asList(male, female));
    final List<Employee> females = HRService.getFemaleEmployees();
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
    final long actualTenure = HRService.getTenureInDaysForEmployee(employee);
    Assert.assertEquals(TENURE, actualTenure);
  }
}
