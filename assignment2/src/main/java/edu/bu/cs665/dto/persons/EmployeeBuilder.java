package edu.bu.cs665.dto.persons;

import java.time.LocalDate;

public class EmployeeBuilder {
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

  public EmployeeBuilder setFirstName(final String firstName) {
    this.firstName = firstName;
    return this;
  }

  public EmployeeBuilder setLastName(final String lastName) {
    this.lastName = lastName;
    return this;
  }

  public EmployeeBuilder setMiddleInitial(final String middleInitial) {
    this.middleInitial = middleInitial;
    return this;
  }

  public EmployeeBuilder setId(final int id) {
    this.id = id;
    return this;
  }

  public EmployeeBuilder setAddress(final String address) {
    this.address = address;
    return this;
  }

  public EmployeeBuilder setTitle(final String title) {
    this.title = title;
    return this;
  }

  public EmployeeBuilder setSalary(final int salary) {
    this.salary = salary;
    return this;
  }

  public EmployeeBuilder setStartDate(final LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  public EmployeeBuilder setCitizenStatus(final CitizenStatus citizenStatus) {
    this.citizenStatus = citizenStatus;
    return this;
  }

  public EmployeeBuilder setGender(final Gender gender) {
    this.gender = gender;
    return this;
  }

  public EmployeeBuilder setWorkLocation(final WorkLocation workLocation) {
    this.workLocation = workLocation;
    return this;
  }

  public EmployeeBuilder setDepartment(final Department department) {
    this.department = department;
    return this;
  }

  public EmployeeBuilder setEmploymentRole(final EmploymentRole employmentRole) {
    this.employmentRole = employmentRole;
    return this;
  }

  public Employee createEmployee() {
    return new Employee(
        firstName,
        lastName,
        middleInitial,
        id,
        address,
        title,
        salary,
        startDate,
        citizenStatus,
        gender,
        workLocation,
        department,
        employmentRole);
  }
}
