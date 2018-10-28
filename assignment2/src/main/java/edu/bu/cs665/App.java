package edu.bu.cs665;

import edu.bu.cs665.resource.AccountingResource;
import edu.bu.cs665.resource.Chooser;
import edu.bu.cs665.resource.ChooserImpl;
import edu.bu.cs665.resource.HRResource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

  private static final HRResource HR_RESOURCE = new HRResource();
  private static final AccountingResource ACCOUNTING_RESOURCE = new AccountingResource();
  private static final String HR_MENU_ITEM = "HR Module";
  private static final String ACCOUNTING_MENU_ITEM = "Accounting Module";
  private static final String QUIT_MENU_ITEM = "Quit";
  private static final Map<String, Runnable> appMenu = new LinkedHashMap<>();

  static {
    appMenu.put(HR_MENU_ITEM, HR_RESOURCE::menu);
    appMenu.put(ACCOUNTING_MENU_ITEM, ACCOUNTING_RESOURCE::menu);
    appMenu.put(QUIT_MENU_ITEM, () -> {});
  }

  public static void main(final String[] args) {
    final Chooser chooser = new ChooserImpl();
    String choice;
    do {
      choice = chooser.getSingleChoice(new ArrayList<>(appMenu.keySet()));
      appMenu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
