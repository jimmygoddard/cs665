package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.ArrayList;
import java.util.List;

public class PersistenceImpl implements Persistence {
  private final List<Employee> employees = new ArrayList<>();

  private PersistenceImpl() {}

  private static class PersistenceImplHolder {
    private static final Persistence instance = new PersistenceImpl();
  }

  public static Persistence getPersistence() {
    return PersistenceImplHolder.instance;
  }

  @Override
  public List<Employee> getEmployees() {
    return employees;
  }
}
