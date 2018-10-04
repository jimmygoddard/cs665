package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public class PersonsDaoImpl implements PersonsDao {

  private final Persistence persistence = PersistenceImpl.getPersistence();
  private final List<Employee> employees = persistence.getEmployees();

  private PersonsDaoImpl() {}

  private static class PersonsDaoImplHolder {
    private static final PersonsDao instance = new PersonsDaoImpl();
  }

  public static PersonsDao getPersonsDao() {
    return PersonsDaoImplHolder.instance;
  }

  @Override
  public void addEmployee(final Employee employee) {
    employees.add(employee);
  }

  private int getIndexOfEmployeeById(final int id) {
    int i = 0;
    for (final Employee emp : employees) {
      if (emp.getId() == id) {
        break;
      }
      ++i;
    }
    return i;
  }

  @Override
  public void updateEmployee(final int id, final Employee employee) {
    final int i = getIndexOfEmployeeById(id);
    employees.set(i, employee);
  }

  @Override
  public void deleteEmployee(final int id) {
    final int i = getIndexOfEmployeeById(id);
    employees.remove(i);
  }

  @Override
  public List<Employee> getEmployees() {
    return this.employees;
  }
}
