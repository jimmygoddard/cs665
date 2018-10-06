package edu.bu.cs665.service;

import static java.time.temporal.ChronoUnit.DAYS;

import edu.bu.cs665.dao.PersonsDao;
import edu.bu.cs665.dao.PersonsDaoImpl;
import edu.bu.cs665.dto.persons.CitizenStatus;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Gender;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsServiceImpl implements PersonsService {
  private final PersonsDao personsDao = PersonsDaoImpl.getPersonsDao();

  private PersonsServiceImpl() {}

  private static class PersonsServiceImplHolder {
    private static final PersonsService instance = new PersonsServiceImpl();
  }

  public static PersonsService getPersonsService() {
    return PersonsServiceImplHolder.instance;
  }

  @Override
  public void addEmployee(final Employee employee) {
    personsDao.addEmployee(employee);
  }

  @Override
  public void updateEmployee(final int id, final Employee employee)
      throws EmployeeNotFoundException {
    personsDao.updateEmployee(id, employee);
  }

  @Override
  public void deleteEmployee(final int id) throws EmployeeNotFoundException {
    personsDao.deleteEmployee(id);
  }

  @Override
  public List<Employee> getEmployees() {
    return personsDao.getEmployees();
  }

  @Override
  public Employee getEmployee(final int id) throws EmployeeNotFoundException {
    return getEmployees()
        .stream()
        .filter(employee -> employee.getId() == id)
        .findFirst()
        .orElseThrow(() -> new EmployeeNotFoundException("employee not found for id " + id));
  }

  @Override
  public List<Employee> getEmployeesFromUS() {
    return getEmployees()
        .stream()
        .filter(employee -> employee.getCitizenStatus().equals(CitizenStatus.CITIZEN))
        .collect(Collectors.toList());
  }

  @Override
  public List<Employee> getEmployeesNotInUS() {
    return getEmployees()
        .stream()
        .filter(employee -> employee.getCitizenStatus().equals(CitizenStatus.VISA))
        .collect(Collectors.toList());
  }

  @Override
  public List<Employee> getMaleEmployees() {
    return getEmployees()
        .stream()
        .filter(employee -> employee.getGender().equals(Gender.MALE))
        .collect(Collectors.toList());
  }

  @Override
  public List<Employee> getFemaleEmployees() {
    return getEmployees()
        .stream()
        .filter(employee -> employee.getGender().equals(Gender.FEMALE))
        .collect(Collectors.toList());
  }

  @Override
  public long getTenureInDaysForEmployee(final Employee employee) {
    final LocalDate startDate = employee.getStartDate();
    return DAYS.between(startDate, LocalDate.now());
  }
}
