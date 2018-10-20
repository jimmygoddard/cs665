package edu.bu.cs665.dto.persons;

import java.time.LocalDate;

public class Employee {
  private static final int ID = 0;

  private String firstName;
  private String lastName;
  private String middleInitial;
  private int id;
  private String address;
  private String title;
  private double salary;
  private LocalDate startDate;
  private CitizenStatus citizenStatus;
  private Gender gender;
  private WorkLocation workLocation;
  private DepartmentType departmentType;
  private EmploymentRole employmentRole;

  private Employee(
      final String firstName,
      final String lastName,
      final String middleInitial,
      final int id,
      final String address,
      final String title,
      final double salary,
      final LocalDate startDate,
      final CitizenStatus citizenStatus,
      final Gender gender,
      final WorkLocation workLocation,
      final DepartmentType departmentType,
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
    this.departmentType = departmentType;
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
    return this.id;
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

  public double getSalary() {
    return salary;
  }

  public void setSalary(final double salary) {
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

  public DepartmentType getDepartmentType() {
    return departmentType;
  }

  public void setDepartmentType(final DepartmentType departmentType) {
    this.departmentType = departmentType;
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
        + ", departmentType="
        + departmentType
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
    private double salary;
    private LocalDate startDate;
    private CitizenStatus citizenStatus;
    private Gender gender;
    private WorkLocation workLocation;
    private DepartmentType departmentType;
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

    public EmployeeBuilder setSalary(final double salary) {
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

    public EmployeeBuilder setDepartmentType(final DepartmentType departmentType) {
      this.departmentType = departmentType;
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
          departmentType,
          employmentRole);
    }
  }
}
