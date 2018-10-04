package edu.bu.cs665.service;

import edu.bu.cs665.dao.PersonsDao;
import edu.bu.cs665.dao.PersonsDaoImpl;
import edu.bu.cs665.dto.persons.Employee;

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
}
