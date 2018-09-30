package edu.bu.cs665.dao;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface Persistence {

  List<Employee> getEmployees();

}
