package edu.bu.cs665.service;

import edu.bu.cs665.dao.PersonsDao;
import edu.bu.cs665.dao.PersonsDaoImpl;

public class PersonsServiceImpl implements PersonsService {
  private final PersonsDao personsDao = PersonsDaoImpl.getPersonsDao();

  private PersonsServiceImpl() {}

  private static class PersonsServiceImplHolder {
    public static final PersonsService instance = new PersonsServiceImpl();
  }

  public static PersonsService getPersonsService() {
    return PersonsServiceImplHolder.instance;
  }
}
