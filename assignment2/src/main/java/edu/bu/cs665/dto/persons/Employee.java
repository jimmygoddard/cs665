package edu.bu.cs665.dto.persons;

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

  private Employee(
      final String firstName,
      final String lastName,
      final String middleInitial,
      final int id,
      final String address,
      final String title,
      final int salary,
      final LocalDate startDate,
      final CitizenStatus citizenStatus,
      final Gender gender,
      final WorkLocation workLocation,
      final Department department,
      final EmploymentRole employmentRole) {
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleInitial() {
    return middleInitial;
  }

  public void setMiddleInitial(final String middleInitial) {
    this.middleInitial = middleInitial;
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(final int salary) {
    this.salary = salary;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(final LocalDate startDate) {
    this.startDate = startDate;
  }

  public CitizenStatus getCitizenStatus() {
    return citizenStatus;
  }

  public void setCitizenStatus(final CitizenStatus citizenStatus) {
    this.citizenStatus = citizenStatus;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(final Gender gender) {
    this.gender = gender;
  }

  public WorkLocation getWorkLocation() {
    return workLocation;
  }

  public void setWorkLocation(final WorkLocation workLocation) {
    this.workLocation = workLocation;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(final Department department) {
    this.department = department;
  }

  public EmploymentRole getEmploymentRole() {
    return employmentRole;
  }

  public void setEmploymentRole(final EmploymentRole employmentRole) {
    this.employmentRole = employmentRole;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", middleInitial='"
        + middleInitial
        + '\''
        + ", id="
        + id
        + ", address='"
        + address
        + '\''
        + ", title='"
        + title
        + '\''
        + ", salary="
        + salary
        + ", startDate="
        + startDate
        + ", citizenStatus="
        + citizenStatus
        + ", gender="
        + gender
        + ", workLocation="
        + workLocation
        + ", department="
        + department
        + ", employmentRole="
        + employmentRole
        + '}';
  }

  public static class EmployeeBuilder {
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
}
