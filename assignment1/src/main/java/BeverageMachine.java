import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BeverageMachine {

  private Beverage beverage;

  public BeverageMachine() {}

  /**
   * Dispenses the beverage which was just prepared
   *
   * @return the beverage which has been prepared
   */
  public Beverage dispense() {
    return this.beverage;
  }

  /** Turns on the BeverageMachine */
  public void turnOn() {
    System.out.println("Welcome to the Fully Automatic Beverage Vending Machine!");
  }

  /**
   * Choose the category of beverage for the beverage machine to make. Can currently be either
   * coffee or tea
   */
  public void chooseBeverageCategory() {
    final Scanner keyboard = new Scanner(System.in);
    while (this.beverage == null) {
      System.out.print("Would you like to make coffee or tea? ");
      String choice = "";
      try {
        choice = keyboard.nextLine();
      } catch (final InputMismatchException e) {
        keyboard.reset();
        keyboard.next();
      }
      switch (choice) {
        case "tea":
          this.beverage = new Tea();
          break;
        case "coffee":
          this.beverage = new Coffee();
          break;
        default:
          System.out.println(
              "I'm sorry, I did not understand your choice. Please type 'coffee' or 'tea'.");
      }
    }
  }

  /**
   * Choose the type of beverage. For tea this can be black, green, or yellow. For coffee, this can
   * be americano espresso or latte machiato. If coffee is being brewed, this will also prompt the
   * user to choose if they would like to add milk or sugar and how much.
   */
  public void chooseBeverageType() {
    final String type = chooseBeverageType(this.beverage.getTypes());
    this.beverage.setType(type);
    if (this.beverage instanceof Coffee) {
      final Coffee coffee = ((Coffee) beverage);
      final List<String> choices = Arrays.asList("milk", "sugar", "done");
      String condiment = "";
      while (!condiment.equals("done")) {
        condiment = chooseCondiment(choices);
        switch (condiment) {
          case "milk":
            final int milkUnits = chooseUnits(coffee);
            coffee.setMilkUnits(milkUnits);
            break;
          case "sugar":
            final int sugarUnits = chooseUnits(coffee);
            coffee.setSugarUnits(sugarUnits);
        }
      }
    }
  }

  private String chooseBeverageType(final List<String> types) {
    final Scanner keyboard = new Scanner(System.in);
    String type = null;
    while (type == null) {
      System.out.println(
          String.format("What type of %s would you like?", this.beverage.getDescriptor()));
      System.out.println();
      for (int i = 0; i < types.size(); ++i) {
        System.out.println(String.format("\t%d. %s", i + 1, types.get(i)));
      }
      System.out.println();
      final String prompt = String.format("Please select between 1 and %d: ", types.size());
      System.out.print(prompt);
      int choice = -1;
      try {
        choice = keyboard.nextInt();
      } catch (final InputMismatchException e) {
        keyboard.reset();
        keyboard.next();
      }
      if (choice < 1 || choice > types.size()) {
        System.out.println("I'm sorry, I did not understand your choice.");
      } else {
        type = types.get(choice - 1);
      }
    }
    return type;
  }

  private String chooseCondiment(final List<String> condiments) {
    final Scanner keyboard = new Scanner(System.in);
    String condiment = null;
    while (condiment == null) {
      System.out.println("Would you like to add milk or sugar to your beverage?");
      System.out.println();
      for (int i = 0; i < condiments.size(); ++i) {
        System.out.println(String.format("\t%d. %s", i + 1, condiments.get(i)));
      }
      System.out.println();
      final String prompt = String.format("Please select between 1 and %d: ", condiments.size());
      System.out.print(prompt);
      int choice = -1;
      try {
        choice = keyboard.nextInt();
      } catch (final InputMismatchException e) {
        keyboard.reset();
        keyboard.next();
      }
      if (choice < 1 || choice > condiments.size()) {
        System.out.println("I'm sorry, I did not understand your choice.");
      } else {
        condiment = condiments.get(choice - 1);
      }
    }
    return condiment;
  }

  private int chooseUnits(final Coffee coffee) {
    final Scanner keyboard = new Scanner(System.in);
    final int min = coffee.getMin();
    final int max = coffee.getMax();
    int units = -1;
    while (units < min || units > max) {
      System.out.print(
          String.format(
              "How many units would you like to add to your beverage? [%d-%d] ", min, max));
      try {
        units = keyboard.nextInt();
      } catch (final InputMismatchException e) {
        keyboard.reset();
        keyboard.next();
      }
    }
    return units;
  }

  /** Brew the beverage and make the beverage machine ready to brew another beverage */
  public void brewBeverage() {
    System.out.println("Now dispensing: " + this.beverage);
    this.beverage = null;
  }
}
