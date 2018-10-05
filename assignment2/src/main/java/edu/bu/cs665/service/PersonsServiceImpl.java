package edu.bu.cs665.service;

import edu.bu.cs665.dao.PersonsDao;
import edu.bu.cs665.dao.PersonsDaoImpl;
import edu.bu.cs665.dto.persons.CitizenStatus;
import edu.bu.cs665.dto.persons.Employee;
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
  public void updateEmployee(final int id, final Employee employee) {
    personsDao.updateEmployee(id, employee);
  }

  @Override
  public void deleteEmployee(final int id) {
    personsDao.deleteEmployee(id);
  }

  @Override
  public List<Employee> getEmployeesFromUS() {
    final List<Employee> employees = personsDao.getEmployees();
    return employees
        .stream()
        .filter(employee -> employee.getCitizenStatus().equals(CitizenStatus.CITIZEN))
        .collect(Collectors.toList());
  }

  @Override
  public List<Employee> getEmployeesNotInUS() {
    return null;
  }

  @Override
  public List<Employee> getMaleEmployees() {
    return null;
  }

  @Override
  public List<Employee> getFemaleEmployees() {
    return null;
  }
}
