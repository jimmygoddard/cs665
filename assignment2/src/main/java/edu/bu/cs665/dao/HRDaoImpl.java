package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import java.util.List;

public class HRDaoImpl implements HRDao {

  private final PersonStore personStore = PersonStoreImpl.getPersistence();

  private HRDaoImpl() {}

  private static class HRDaoImplHolder {
    private static final HRDao instance = new HRDaoImpl();
  }

  public static HRDao getHRDao() {
    return HRDaoImplHolder.instance;
  }

  @Override
  public void addEmployee(final Employee employee) {
    final List<Employee> employees = getEmployees();
    employees.add(employee);
    personStore.setEmployees(employees);
  }

  @Override
  public void updateEmployee(final int id, final Employee employee)
      throws EmployeeNotFoundException {
    final int i = getIndexOfEmployeeById(id);
    final List<Employee> employees = getEmployees();
    employee.setId(id);
    employees.set(i, employee);
    personStore.setEmployees(employees);
  }

  @Override
  public void deleteEmployee(final int id) throws EmployeeNotFoundException {
    final int i = getIndexOfEmployeeById(id);
    final List<Employee> employees = getEmployees();
    employees.remove(i);
    personStore.setEmployees(employees);
  }

  @Override
  public List<Employee> getEmployees() {
    return personStore.getEmployees();
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
