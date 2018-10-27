package edu.bu.cs665.dto.persons;

import edu.bu.cs665.dto.Invoice;
import edu.bu.cs665.dto.Payable;
import edu.bu.cs665.exception.AllowanceExceededException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Payable {
  private final String firstName;
  private final String lastName;
  private final String middleInitial;
  private int id;
  private final String address;
  private final String title;
  private final double salary;
  private final LocalDate startDate;
  private final CitizenStatus citizenStatus;
  private final Gender gender;
  private final WorkLocation workLocation;
  private final DepartmentType departmentType;
  private EmploymentRole employmentRole;
  private final List<Invoice> expenses = new ArrayList<>();

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

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public CitizenStatus getCitizenStatus() {
    return citizenStatus;
  }

  public Gender getGender() {
    return gender;
  }

  private List<Invoice> getExpenses() {
    return this.expenses;
  }

  public void addExpense(final Invoice expense) {
    getExpenses().add(expense);
  }

  public void setEmploymentRole(final EmploymentRole employmentRole) {
    this.employmentRole = employmentRole;
  }

  public EmploymentRole getEmploymentRole() {
    return this.employmentRole;
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

  @Override
  public double getBalance() {
    return getExpenses().stream().mapToDouble(Invoice::getBalance).sum();
  }

  @Override
  public double payBalance(double payment) throws AllowanceExceededException {
    final double allowableAmount = EmploymentRole.getTotalAllowance(this.employmentRole);
    if (payment > allowableAmount) {
      throw new AllowanceExceededException(
          "Payment "
              + payment
              + " is higher than the allowable expense limit for employment role "
              + this.employmentRole);
    }
    for (final Invoice expense : getExpenses()) {
      final double balance = expense.getBalance();
      if (balance > 0) {
        payment = expense.payBalance(payment);
        if (payment <= 0) { // payment was less than balance
          return 0;
        }
      }
    }
    return payment;
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
