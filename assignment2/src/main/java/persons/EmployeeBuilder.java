package persons;

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

  public EmployeeBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public EmployeeBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public EmployeeBuilder setMiddleInitial(String middleInitial) {
    this.middleInitial = middleInitial;
    return this;
  }

  public EmployeeBuilder setId(int id) {
    this.id = id;
    return this;
  }

  public EmployeeBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public EmployeeBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public EmployeeBuilder setSalary(int salary) {
    this.salary = salary;
    return this;
  }

  public EmployeeBuilder setStartDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  public EmployeeBuilder setCitizenStatus(CitizenStatus citizenStatus) {
    this.citizenStatus = citizenStatus;
    return this;
  }

  public EmployeeBuilder setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public EmployeeBuilder setWorkLocation(WorkLocation workLocation) {
    this.workLocation = workLocation;
    return this;
  }

  public EmployeeBuilder setDepartment(Department department) {
    this.department = department;
    return this;
  }

  public EmployeeBuilder setEmploymentRole(EmploymentRole employmentRole) {
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
