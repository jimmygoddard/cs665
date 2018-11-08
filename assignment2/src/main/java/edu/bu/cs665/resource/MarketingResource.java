package edu.bu.cs665.resource;

import edu.bu.cs665.service.MarketingService;
import edu.bu.cs665.service.MarketingServiceImpl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

  private final Map<String, Runnable> m_marketingMenu = new LinkedHashMap<>();
  private final Chooser m_chooser = new ChooserImpl();
  private final MarketingService m_marketingService = new MarketingServiceImpl();

  public MarketingResource() {
    m_marketingMenu.put(
        EMAIL_POTENTIAL_CUSTOMERS_MENU_ITEM,
        () -> m_marketingService.emailCustomers(m_marketingService.getPotentialCustomers()));
    m_marketingMenu.put(LIST_BUSINESS_PARTNERS_MENU_ITEM, () -> {});
    m_marketingMenu.put(LIST_COMPLETED_SALES_MENU_ITEM, () -> {});
    m_marketingMenu.put(LIST_IN_PROGRESS_SALES_MENU_ITEM, () -> {});
    m_marketingMenu.put(LIST_NOT_STARTED_SALES_MENU_ITEM, () -> {});
    m_marketingMenu.put(SHOW_NO_SALES_REASONS, () -> {});
  }

  public void menu() {
    String choice;
    do {
      choice = m_chooser.getSingleChoice(new ArrayList<>(m_marketingMenu.keySet()));
      m_marketingMenu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
