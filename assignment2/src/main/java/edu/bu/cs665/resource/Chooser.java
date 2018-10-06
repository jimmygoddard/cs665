package edu.bu.cs665.resource;

import edu.bu.cs665.dto.persons.Employee;
import java.util.List;

public interface Chooser {

  /**
   * Present a menu of employees to choose from
   *
   * @param employees the list of employees from which to choose
   * @return the id of the chosen employee
   */
  String getEmployeeChoice(List<Employee> employees);

  /**
   * Present a menu of items to choose from
   *
   * @param choices the list of choices from which to choose
   * @param showPrompt whether or not to show the default prompt
   * @return the item from the list of choices which was selected
   */
  String getSingleChoice(List<String> choices, boolean showPrompt);

  /**
   * Preent a menu of choices to choose from
   *
   * @param choices the list of choices from which to choose
   * @return the item from the list of choices which was selected
   */
  String getSingleChoice(List<String> choices);

  /**
   * Present a menu of choices to choose from allowing multiple selections
   *
   * @param choices the list of choices from which to choose
   * @return the list selections from the list of choices
   */
  List<String> getMultipleChoices(List<String> choices);
}
