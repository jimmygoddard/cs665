package edu.bu.cs665.util;

import edu.bu.cs665.dto.persons.CitizenStatus;
import edu.bu.cs665.dto.persons.Department;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.Employee.EmployeeBuilder;
import edu.bu.cs665.dto.persons.EmploymentRole;
import edu.bu.cs665.dto.persons.Gender;
import edu.bu.cs665.dto.persons.WorkLocation;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;
import org.fluttercode.datafactory.impl.DataFactory;

public class EmployeeGenerator {
  private static final DataFactory dataFactory = new DataFactory();

  private static int id = 0;

  public static Employee generateEmployee() {
    return new EmployeeBuilder()
        .setAddress(dataFactory.getAddress())
        .setCitizenStatus(
            CitizenStatus.values()[dataFactory.getNumberUpTo(CitizenStatus.values().length)])
        .setDepartment(Department.values()[dataFactory.getNumberUpTo(Department.values().length)])
        .setEmploymentRole(
            EmploymentRole.values()[dataFactory.getNumberUpTo(EmploymentRole.values().length)])
        .setFirstName(dataFactory.getFirstName())
        .setLastName(dataFactory.getLastName())
        .setId(id++)
        .setMiddleInitial(String.valueOf(dataFactory.getRandomChar()).toUpperCase())
        .setStartDate(
            LocalDate.of(
                dataFactory.getNumberBetween(2000, 2018),
                dataFactory.getNumberBetween(1, 12),
                dataFactory.getNumberBetween(1, 28)))
        .setSalary(dataFactory.getNumberBetween(10_000, 100_000))
        .setWorkLocation(
            WorkLocation.values()[dataFactory.getNumberUpTo(WorkLocation.values().length)])
        .setTitle(StringUtils.capitalize(dataFactory.getRandomWord()))
        .setGender(Gender.values()[dataFactory.getNumberUpTo(Gender.values().length)])
        .createEmployee();
  }

  public static List<Employee> generateEmployees(final int numEmployees) {
    return IntStream.rangeClosed(1, numEmployees)
        .mapToObj(i -> generateEmployee())
        .collect(Collectors.toList());
  }
}
