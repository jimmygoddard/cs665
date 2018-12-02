package edu.bu.cs665.util;

import edu.bu.cs665.dto.car.Car;
import java.util.List;

public interface MenuGenerator {

  /**
   * Present a menu of cars to choose from
   *
   * @param cars the list of cars from which to choose
   * @return the id of the chosen employee
   */
  String getCarChoice(List<Car> cars);

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
