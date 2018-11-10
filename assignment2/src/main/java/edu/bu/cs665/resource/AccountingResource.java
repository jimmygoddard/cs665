package edu.bu.cs665.resource;

import edu.bu.cs665.dao.BankImpl;
import edu.bu.cs665.dao.CustomerStoreImpl;
import edu.bu.cs665.dao.VendorStoreImpl;
import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.service.AccountingService;
import edu.bu.cs665.service.AccountingServiceImpl;
import edu.bu.cs665.service.CustomerService;
import edu.bu.cs665.service.CustomerServiceImpl;
import edu.bu.cs665.service.HRService;
import edu.bu.cs665.service.HRServiceImpl;
import edu.bu.cs665.service.VendorService;
import edu.bu.cs665.service.VendorServiceImpl;
import edu.bu.cs665.util.CustomerGenerator;
import edu.bu.cs665.util.VendorGenerator;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AccountingResource {
  private static final String GENERATE_VENDORS_MENU_ITEM = "Generate vendors";
  private static final String GENERATE_CUSTOMERS_MENU_ITEM = "Generate customers";
  private static final String LIST_VENDORS_MENU_ITEM = "List vendors";
  private static final String LIST_CUSTOMERS_MENU_ITEM = "List customers";
  private static final String PAY_VENDORS_MENU_ITEM = "Pay vendors";
  private static final String RECEIVE_PAYMENTS_FROM_CUSTOMERS_MENU_ITEM =
      "Receive payments from customers";
  private static final String PAY_EMPLOYEE_EXPENSES_MENU_ITEM = "Pay employees' expenses";
  private static final String PRINT_BANK_BALANCE_MENU_ITEM = "Print bank balance";
  private static final String QUIT_MENU_ITEM = "Quit Accounting Module";

  private final AccountingService accountingService = new AccountingServiceImpl(BankImpl.getBank());
  private final CustomerService customerService =
      new CustomerServiceImpl(CustomerStoreImpl.getCustomerStore());
  private final VendorService vendorService =
      new VendorServiceImpl(VendorStoreImpl.getVendorStore());
  private final HRService hrService = HRServiceImpl.getHRService();
  private final Map<String, Runnable> accountingMenu = new LinkedHashMap<>();
  private final Chooser chooser = new ChooserImpl();

  public AccountingResource() {
    accountingMenu.put(
        GENERATE_VENDORS_MENU_ITEM,
        () -> {
          System.out.println("Generating 10 vendors");
          vendorService.setVendors(VendorGenerator.generateVendors(10));
        });
    accountingMenu.put(
        GENERATE_CUSTOMERS_MENU_ITEM,
        () -> {
          System.out.println("Generating 10 customers");
          customerService.setCustomers(CustomerGenerator.generateCustomers(10));
        });
    accountingMenu.put(
        LIST_VENDORS_MENU_ITEM, () -> vendorService.getVendors().forEach(System.out::println));
    accountingMenu.put(
        LIST_CUSTOMERS_MENU_ITEM,
        () -> customerService.getCustomers().forEach(System.out::println));
    accountingMenu.put(
        PAY_VENDORS_MENU_ITEM,
        () -> {
          if (vendorService.getVendors().isEmpty()) {
            System.out.println("No vendors to pay");
            return;
          }
          System.out.println("Paying all vendors");
          accountingService.payVendors(vendorService.getVendors());
        });
    accountingMenu.put(
        RECEIVE_PAYMENTS_FROM_CUSTOMERS_MENU_ITEM,
        () -> {
          if (customerService.getCustomers().isEmpty()) {
            System.out.println("No customers from which to recieve payment");
            return;
          }
          System.out.println("Receiving payment from customers");
          accountingService.receivePayments(customerService.getCustomers());
        });
    accountingMenu.put(
        PAY_EMPLOYEE_EXPENSES_MENU_ITEM,
        () -> {
          final List<Employee> employees = hrService.getEmployees();
          if (employees.isEmpty()) {
            System.out.println(
                "No employees to expense.  Please add employees through the HR Module");
            return;
          }
          accountingService.payExpenses(employees);
        });
    accountingMenu.put(
        PRINT_BANK_BALANCE_MENU_ITEM,
        () -> {
          System.out.println(NumberFormat.getInstance().format(accountingService.getBalance()));
        });
    accountingMenu.put(QUIT_MENU_ITEM, () -> {});
  }

  public void menu() {
    String choice;
    do {
      choice = chooser.getSingleChoice(new ArrayList<>(accountingMenu.keySet()));
      accountingMenu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
