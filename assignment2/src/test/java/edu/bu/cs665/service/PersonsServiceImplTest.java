package edu.bu.cs665.service;

import edu.bu.cs665.dao.Persistence;
import edu.bu.cs665.dao.PersistenceImpl;
import edu.bu.cs665.dto.persons.CitizenStatus;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Gender;
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

  @Test
  public void getPersonsService() {
    final PersonsService instanceOne = PersonsServiceImpl.getPersonsService();
    final PersonsService instanceTwo = PersonsServiceImpl.getPersonsService();
    Assert.assertSame(instanceOne, instanceTwo);
  }

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

  @Test
  public void updateEmployee() {
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

  @Test
  public void deleteEmployee() {
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

  @Test
  public void getEmployees() {
    final List<Employee> expectedEmployees = persistence.getEmployees();
    final List<Employee> actualEmployees = personsService.getEmployees();
    Assert.assertEquals(expectedEmployees, actualEmployees);
  }

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

  @Test
  public void getMaleEmployees() {
    final Employee male = new Employee.EmployeeBuilder().setGender(Gender.MALE).createEmployee();
    final Employee female =
        new Employee.EmployeeBuilder().setGender(Gender.FEMALE).createEmployee();
    persistence.setEmployees(Arrays.asList(male, female));
    final List<Employee> males = personsService.getMaleEmployees();
    Assert.assertEquals(Collections.singletonList(male), males);
  }

  @Test
  public void getFemaleEmployees() {
    final Employee male = new Employee.EmployeeBuilder().setGender(Gender.MALE).createEmployee();
    final Employee female =
        new Employee.EmployeeBuilder().setGender(Gender.FEMALE).createEmployee();
    persistence.setEmployees(Arrays.asList(male, female));
    final List<Employee> females = personsService.getFemaleEmployees();
    Assert.assertEquals(Collections.singletonList(female), females);
  }

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
