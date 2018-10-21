package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import java.util.List;

public class HRDaoImpl implements HRDao {

  private final Persistence persistence = PersistenceImpl.getPersistence();

  private HRDaoImpl() {}

  private static class PersonsDaoImplHolder {
    private static final HRDao instance = new HRDaoImpl();
  }

  public static HRDao getPersonsDao() {
    return PersonsDaoImplHolder.instance;
  }

  @Override
  public void addEmployee(final Employee employee) {
    final List<Employee> employees = getEmployees();
    employees.add(employee);
    persistence.setEmployees(employees);
  }

  @Override
  public void updateEmployee(final int id, final Employee employee)
      throws EmployeeNotFoundException {
    final int i = getIndexOfEmployeeById(id);
    final List<Employee> employees = getEmployees();
    employee.setId(id);
    employees.set(i, employee);
    persistence.setEmployees(employees);
  }

  @Override
  public void deleteEmployee(final int id) throws EmployeeNotFoundException {
    final int i = getIndexOfEmployeeById(id);
    final List<Employee> employees = getEmployees();
    employees.remove(i);
    persistence.setEmployees(employees);
  }

  @Override
  public List<Employee> getEmployees() {
    return persistence.getEmployees();
  }

  private int getIndexOfEmployeeById(final int id) throws EmployeeNotFoundException {
    int i = 0;
    boolean found = false;
    final List<Employee> employees = getEmployees();
    for (final Employee employee : employees) {
      if (employee.getId() == id) {
        found = true;
        break;
      }
      ++i;
    }
    if (!found) {
      throw new EmployeeNotFoundException("no employee with id " + id);
    }
    return i;
  }
}
