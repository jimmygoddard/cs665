package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Employee.EmployeeBuilder;
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

  @Test
  public void getPersonsDao() {
    final PersonsDao instanceOne = PersonsDaoImpl.getPersonsDao();
    final PersonsDao instanceTwo = PersonsDaoImpl.getPersonsDao();
    Assert.assertSame(instanceOne, instanceTwo);
  }

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

  @Test
  public void updateEmployee() {
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

  @Test
  public void deleteEmployee() {
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

  @Test
  public void getEmployees() {
    final List<Employee> expectedEmployees = persistence.getEmployees();
    final List<Employee> actualEmployees = personsDao.getEmployees();
    Assert.assertEquals(expectedEmployees, actualEmployees);
  }
}
