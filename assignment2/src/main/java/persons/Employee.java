package persons;

import java.time.LocalDate;

public class Employee {
  private String firstName;
  private String lastName;
  private String middleInitial;
  private int id;
  private String address;
  private String title;
  private int salary;
  private LocalDate startDate;
  private CitizenStatus citizenStatus;
  private Gender gender;
  private WorkLocation workLocation;
  private Department department;
  private EmploymentRole employmentRole;

  Employee(
      String firstName,
      String lastName,
      String middleInitial,
      int id,
      String address,
      String title,
      int salary,
      LocalDate startDate,
      CitizenStatus citizenStatus,
      Gender gender,
      WorkLocation workLocation,
      Department department,
      EmploymentRole employmentRole) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleInitial = middleInitial;
    this.id = id;
    this.address = address;
    this.title = title;
    this.salary = salary;
    this.startDate = startDate;
    this.citizenStatus = citizenStatus;
    this.gender = gender;
    this.workLocation = workLocation;
    this.department = department;
    this.employmentRole = employmentRole;
  }
}
