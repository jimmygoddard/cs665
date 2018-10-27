package edu.bu.cs665.service;

import edu.bu.cs665.dao.BankImpl;
import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.EmploymentRole;
import edu.bu.cs665.util.CustomerGenerator;
import edu.bu.cs665.util.EmployeeGenerator;
import edu.bu.cs665.util.VendorGenerator;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountingServiceImplTest {

  private AccountingService m_accountingService;

  @Before
  public void setUp() {
    m_accountingService = new AccountingServiceImpl(BankImpl.getBank());
  }

  @Test
  public void payExpenses() {
    final List<Employee> employees = EmployeeGenerator.generateEmployees(10);
    m_accountingService.payExpenses(employees);
    final double actualExpenses = employees.stream().mapToDouble(Employee::getBalance).sum();
    Assert.assertEquals(0, actualExpenses, .001);
  }

  @Test
  public void payExpense() {
    final Employee employee = EmployeeGenerator.generateEmployee();
    employee.setEmploymentRole(EmploymentRole.C_LEVEL);
    final double totalExpenses = employee.getBalance();
    final double originalBankBalance = BankImpl.getBank().getBalance();
    final List<Employee> employees = Collections.singletonList(employee);
    m_accountingService.payExpenses(employees);
    Assert.assertEquals(originalBankBalance - totalExpenses, BankImpl.getBank().getBalance(), .001);
  }

  @Test
  public void payVendors() {
    final List<Vendor> vendors = VendorGenerator.generateVendors(10);
    final double originalTotalExpenses = vendors.stream().mapToDouble(Vendor::getBalance).sum();
    final double originalBankBalance = BankImpl.getBank().getBalance();
    m_accountingService.payVendors(vendors);
    Assert.assertEquals(
        originalBankBalance - originalTotalExpenses, BankImpl.getBank().getBalance(), .001);
  }

  @Test
  public void receivePayments() {
    final List<Customer> customers = CustomerGenerator.generateCustomers(10);
    final double originalTotalPayments =
        customers.stream().mapToDouble(Customer::getTotalCost).sum();
    final double originalBankBalance = BankImpl.getBank().getBalance();
    m_accountingService.receivePayments(customers);
    Assert.assertEquals(
        originalBankBalance + originalTotalPayments, BankImpl.getBank().getBalance(), .001);
  }
}
