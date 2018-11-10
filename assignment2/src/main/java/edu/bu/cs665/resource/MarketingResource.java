package edu.bu.cs665.resource;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.exception.InvalidMarketingStateException;
import edu.bu.cs665.service.MarketingService;
import edu.bu.cs665.service.MarketingServiceImpl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MarketingResource {

  private static final String EMAIL_POTENTIAL_CUSTOMERS_MENU_ITEM = "Email potential customers";
  private static final String LIST_BUSINESS_PARTNERS_MENU_ITEM = "List business partners";
  private static final String LIST_COMPLETED_SALES_MENU_ITEM =
      "List customers to whom we have sold something";
  private static final String LIST_IN_PROGRESS_SALES_MENU_ITEM =
      "List customers with whom we are in the processes of selling";
  private static final String LIST_NOT_STARTED_SALES_MENU_ITEM =
      "List potential new sales opportunities";
  private static final String SHOW_NO_SALES_REASONS =
      "Show reasons why a potential customer did not purchase from us";
  private static final String QUIT_MENU_ITEM = "Quit marketing module";

  private final Map<String, Runnable> marketingMenu = new LinkedHashMap<>();
  private final Chooser chooser = new ChooserImpl();
  private final MarketingService marketingService = new MarketingServiceImpl();

  public MarketingResource() {
    marketingMenu.put(
        EMAIL_POTENTIAL_CUSTOMERS_MENU_ITEM,
        () -> {
          List<String> emails = null;
          try {
            emails = marketingService.emailCustomers();
          } catch (final InvalidMarketingStateException e) {
            System.out.println(e.getMessage());
            return;
          }
          System.out.println("Emailed marketing materials to the following addresses:");
          emails.forEach(System.out::println);
        });
    marketingMenu.put(
        LIST_BUSINESS_PARTNERS_MENU_ITEM,
        () -> {
          List<Vendor> partners = null;
          try {
            partners = marketingService.getPartners();
          } catch (final InvalidMarketingStateException e) {
            System.out.println(e.getMessage());
            return;
          }
          if (partners.isEmpty()) {
            System.out.println("No business partners");
          } else {
            System.out.println("We have the following business partners:");
            partners.forEach(System.out::println);
          }
        });
    marketingMenu.put(
        LIST_COMPLETED_SALES_MENU_ITEM,
        () -> {
          List<Customer> customers = null;
          try {
            customers = marketingService.getCurrentCustomers();
          } catch (final InvalidMarketingStateException e) {
            System.out.println(e.getMessage());
            return;
          }
          if (customers.isEmpty()) {
            System.out.println("No active customers");
          } else {
            System.out.println("We have the following active customers:");
            customers.forEach(System.out::println);
          }
        });
    marketingMenu.put(
        LIST_IN_PROGRESS_SALES_MENU_ITEM,
        () -> {
          List<Customer> customers = null;
          try {
            customers = marketingService.getInProgressCustomers();
          } catch (final InvalidMarketingStateException e) {
            System.out.println(e.getMessage());
            return;
          }
          if (customers.isEmpty()) {
            System.out.println("No in progress customers currently");
          } else {
            System.out.println(
                "We have the following customers with whom we are establishing a sales relationship");
            customers.forEach(System.out::println);
          }
        });
    marketingMenu.put(
        LIST_NOT_STARTED_SALES_MENU_ITEM,
        () -> {
          List<Customer> customers = null;
          try {
            customers = marketingService.getPotentialCustomers();
          } catch (final InvalidMarketingStateException e) {
            System.out.println(e.getMessage());
            return;
          }
          if (customers.isEmpty()) {
            System.out.println("No potential customers currently");
          } else {
            System.out.println(
                "The following is a list of companies that could become our customer");
            customers.forEach(System.out::println);
          }
        });
    marketingMenu.put(
        SHOW_NO_SALES_REASONS,
        () -> {
          List<Customer> customers = null;
          try {
            customers = marketingService.getRejectedCustomers();
          } catch (final InvalidMarketingStateException e) {
            System.out.println(e.getMessage());
            return;
          }
          if (customers.isEmpty()) {
            System.out.println("No customers who have rejected our business currently");
          } else {
            System.out.println("The following companies have decided not to do business with us.");
            System.out.println("Customer Name\tReason for Rejection");
            customers.forEach(
                customer ->
                    System.out.println(
                        String.format(
                            "%s\t%s", customer.getName(), customer.getRejectedSalesReason())));
          }
        });
    marketingMenu.put(QUIT_MENU_ITEM, () -> {});
  }

  public void menu() {
    String choice;
    do {
      choice = chooser.getSingleChoice(new ArrayList<>(marketingMenu.keySet()));
      marketingMenu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
