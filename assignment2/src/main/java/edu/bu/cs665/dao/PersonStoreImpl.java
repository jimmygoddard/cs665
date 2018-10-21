package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.ArrayList;
import java.util.List;

public class PersonStoreImpl implements PersonStore {
  private List<Employee> employees = new ArrayList<>();

  private PersonStoreImpl() {}

  private static class PersistenceImplHolder {
    private static final PersonStore instance = new PersonStoreImpl();
  }

  public static PersonStore getPersistence() {
    return PersistenceImplHolder.instance;
  }

  @Override
  public List<Employee> getEmployees() {
    return employees;
  }

  @Override
  public void setEmployees(final List<Employee> employees) {
    this.employees = employees;
  }
}
