package edu.bu.cs665.service;

import edu.bu.cs665.dao.Bank;
import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.dto.persons.EmploymentRole;
import edu.bu.cs665.exception.AllowanceExceededException;
import edu.bu.cs665.exception.BalanceExceededException;
import java.util.List;

public class AccountingServiceImpl implements AccountingService {

  private final Bank bank;

  public AccountingServiceImpl(final Bank bank) {
    this.bank = bank;
  }

  @Override
  public void payExpenses(final List<Employee> employees) {
    employees.forEach(
        employee -> {
          final double allowance;
          if (employee.getEmploymentRole().equals(EmploymentRole.C_LEVEL)) {
            allowance = bank.getBalance();
          } else {
            allowance = EmploymentRole.getTotalAllowance(employee.getEmploymentRole());
          }
          final double payment;
          try {
            payment = bank.withdrawal(allowance);
          } catch (final BalanceExceededException e) {
            System.err.println(e.getMessage());
            return;
          }
          try {
            final double change = employee.payBalance(payment);
            bank.deposit(change);
          } catch (final AllowanceExceededException e) {
            System.err.println(e.getMessage());
          }
        });
  }

  @Override
  public void payVendors(final List<Vendor> vendors) {
    vendors.forEach(
        vendor -> {
          final double balance = bank.getBalance();
          final double payment;
          try {
            payment = bank.withdrawal(balance);
          } catch (final BalanceExceededException e) {
            System.err.println(e.getMessage());
            return;
          }
          final double change = vendor.payBalance(payment);
          bank.deposit(change);
        });
  }

  @Override
  public void receivePayments(final List<Customer> customers) {
    customers.forEach(customer -> bank.deposit(customer.payForServices()));
  }

  @Override
  public double getBalance() {
    return bank.getBalance();
  }
}
