package edu.bu.cs665;

import edu.bu.cs665.dto.persons.Employee;
import edu.bu.cs665.exception.EmployeeNotFoundException;
import edu.bu.cs665.resource.Chooser;
import edu.bu.cs665.resource.ChooserImpl;
import edu.bu.cs665.service.HRService;
import edu.bu.cs665.service.HRServiceImpl;
import edu.bu.cs665.util.EmployeeGenerator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

  private static final HRService HR_SERVICE = HRServiceImpl.getHRService();
  private static final String CREATE_MENU_ITEM = "Create";
  private static final String UPDATE_MENU_ITEM = "Update";
  private static final String DELETE_MENU_ITEM = "Delete";
  private static final String LIST_MENU_ITEM = "List";
  private static final String MALES_MENU_ITEM = "Only Males";
  private static final String FEMALES_MENU_ITEM = "Only Females";
  private static final String CITIZENS_MENU_ITEM = "Only US Citizens";
  private static final String NON_CITIZENS_MENU_ITEM = "Only Non-US Citizens";
  private static final String TENURE_MENU_ITEM = "Get Tenure";

  public static void main(final String[] args) {
    final Chooser chooser = new ChooserImpl();
    final Map<String, Runnable> topLevelMenu = new LinkedHashMap<>();

    // map of strings which can be used in a menu to the methods which should be called when
    // those menu items are selected
    topLevelMenu.put(
        CREATE_MENU_ITEM, () -> HR_SERVICE.addEmployee(EmployeeGenerator.generateEmployee()));
    topLevelMenu.put(
        UPDATE_MENU_ITEM,
        () -> {
          System.out.println("Please choose the ID of the employee to update:");
          System.out.println();
          final String id = chooser.getEmployeeChoice(HR_SERVICE.getEmployees());
          try {
            HR_SERVICE.updateEmployee(
                Integer.valueOf(id), EmployeeGenerator.generateEmployee());
          } catch (final EmployeeNotFoundException e) {
            e.printStackTrace();
          }
        });
    topLevelMenu.put(
        DELETE_MENU_ITEM,
        () -> {
          System.out.println("Please choose the ID of the employee to delete:");
          System.out.println();
          final String id = chooser.getEmployeeChoice(HR_SERVICE.getEmployees());
          try {
            HR_SERVICE.deleteEmployee(Integer.valueOf(id));
          } catch (final EmployeeNotFoundException e) {
            e.printStackTrace();
          }
        });
    topLevelMenu.put(
        LIST_MENU_ITEM, () -> HR_SERVICE.getEmployees().forEach(System.out::println));
    topLevelMenu.put(
        MALES_MENU_ITEM, () -> HR_SERVICE.getMaleEmployees().forEach(System.out::println));
    topLevelMenu.put(
        FEMALES_MENU_ITEM, () -> HR_SERVICE.getFemaleEmployees().forEach(System.out::println));
    topLevelMenu.put(
        CITIZENS_MENU_ITEM, () -> HR_SERVICE.getEmployeesFromUS().forEach(System.out::println));
    topLevelMenu.put(
        NON_CITIZENS_MENU_ITEM,
        () -> HR_SERVICE.getEmployeesNotInUS().forEach(System.out::println));
    topLevelMenu.put(
        TENURE_MENU_ITEM,
        () -> {
          System.out.println("Please choose the ID of the employee to see their tenure:");
          System.out.println();
          final String id = chooser.getEmployeeChoice(HR_SERVICE.getEmployees());
          try {
            final Employee employee = HR_SERVICE.getEmployee(Integer.valueOf(id));
            System.out.println(
                String.format("%d days", HR_SERVICE.getTenureInDaysForEmployee(employee)));
          } catch (final EmployeeNotFoundException e) {
            e.printStackTrace();
          }
        });

    while (true) {
      final String choice = chooser.getSingleChoice(new ArrayList<>(topLevelMenu.keySet()));
      topLevelMenu.get(choice).run();
    }
  }
}
