package edu.bu.cs665.dto.persons;

import edu.bu.cs665.dto.Invoice;
import edu.bu.cs665.exception.AllowanceExceededException;
import edu.bu.cs665.util.EmployeeGenerator;
import edu.bu.cs665.util.TestDataGenerator;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

  @Test
  public void payBalanceTest() throws AllowanceExceededException {
    final Employee employee = EmployeeGenerator.generateEmployee();
    employee.setEmploymentRole(EmploymentRole.C_LEVEL);
    final Invoice expenseOne = TestDataGenerator.generateTestInvoice();
    final Invoice expenseTwo = TestDataGenerator.generateTestInvoice();
    final Invoice expenseThree = TestDataGenerator.generateTestInvoice();
    employee.addExpense(expenseOne);
    employee.addExpense(expenseTwo);
    employee.addExpense(expenseThree);
    final double actualChange = employee.payBalance(TestDataGenerator.TOTAL_BALANCE * 3);
    Assert.assertEquals(0, actualChange, .001);
  }

  @Test(expected = AllowanceExceededException.class)
  public void payBalanceBasicEmployeeExceededAllowanceTest() throws AllowanceExceededException {
    final Employee employee = EmployeeGenerator.generateEmployee();
    employee.setEmploymentRole(EmploymentRole.FRONT_LINES);
    final Invoice expenseOne = TestDataGenerator.generateTestInvoice();
    final Invoice expenseTwo = TestDataGenerator.generateTestInvoice();
    final Invoice expenseThree = TestDataGenerator.generateTestInvoice();
    employee.addExpense(expenseOne);
    employee.addExpense(expenseTwo);
    employee.addExpense(expenseThree);
    employee.payBalance(TestDataGenerator.TOTAL_BALANCE * 3);
  }

  @Test(expected = AllowanceExceededException.class)
  public void payBalanceManagerExceededAllowanceTest() throws AllowanceExceededException {
    final Employee employee = EmployeeGenerator.generateEmployee();
    employee.setEmploymentRole(EmploymentRole.MANAGER);
    final Invoice expenseOne = TestDataGenerator.generateTestInvoice();
    final Invoice expenseTwo = TestDataGenerator.generateTestInvoice();
    final Invoice expenseThree = TestDataGenerator.generateTestInvoice();
    employee.addExpense(expenseOne);
    employee.addExpense(expenseTwo);
    employee.addExpense(expenseThree);
    employee.payBalance(TestDataGenerator.TOTAL_BALANCE * 3);
  }
}
