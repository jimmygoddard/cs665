package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public class PersonsDaoImpl implements PersonsDao {

  private final Persistence persistence = PersistenceImpl.getPersistence();

  private PersonsDaoImpl() {}

  private static class PersonsDaoImplHolder {
    private static final PersonsDao instance = new PersonsDaoImpl();
  }

  public static PersonsDao getPersonsDao() {
    return PersonsDaoImplHolder.instance;
  }

  @Override
  public void addEmployee(final Employee employee) {
    final List<Employee> employees = getEmployees();
    employees.add(employee);
    persistence.setEmployees(employees);
  }

  @Override
  public void updateEmployee(final int id, final Employee employee) {
    final int i = getIndexOfEmployeeById(id);
    final List<Employee> employees = getEmployees();
    employee.setId(id);
    employees.set(i, employee);
    persistence.setEmployees(employees);
  }

  @Override
  public void deleteEmployee(final int id) {
    final int i = getIndexOfEmployeeById(id);
    final List<Employee> employees = getEmployees();
    employees.remove(i);
    persistence.setEmployees(employees);
  }

  @Override
  public List<Employee> getEmployees() {
    return persistence.getEmployees();
  }

  private int getIndexOfEmployeeById(final int id) {
    int i = 0;
    final List<Employee> employees = getEmployees();
    for (final Employee employee : employees) {
      if (employee.getId() == id) {
        break;
      }
      ++i;
    }
    return i;
  }
}
