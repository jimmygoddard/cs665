import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BeverageMachine {

    private Beverage beverage;

    public BeverageMachine() {
    }

    public Beverage dispense() {
        return this.beverage;
    }

    public void turnOn() {
        System.out.println("Welcome to the Fully Automatic Beverage Vending Machine!");
    }

    public void chooseBeverageCategory() {
        // FIXME catch InputMismatchException
        final Scanner keyboard = new Scanner(System.in);
        while (this.beverage == null) {
            System.out.print("Would you like to make coffee or tea? ");
            final String choice = keyboard.nextLine();
            switch (choice) {
                case "tea":
                    this.beverage = new Tea();
                    break;
                case "coffee":
                    this.beverage = new Coffee();
                    break;
                default:
                    System.out.println("I'm sorry, I did not understand your choice. Please type 'coffee' or 'tea'.");
            }
        }
    }

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
                        final int milkUnits = chooseUnits();
                        coffee.setMilkUnits(milkUnits);
                        break;
                    case "sugar":
                        final int sugarUnits = chooseUnits();
                        coffee.setSugarUnits(sugarUnits);
                }
            }
        }
    }

    private String chooseBeverageType(final List<String> types) {
        final Scanner keyboard = new Scanner(System.in);
        String type = null;
        while (type == null) {
            System.out.println(String.format("What type of %s would you like?", this.beverage.getDescriptor()));
            System.out.println();
            for (int i = 0; i < types.size(); ++i) {
                System.out.println(String.format("\t%d. %s", i + 1, types.get(i)));
            }
            System.out.println();
            final String prompt = String.format("Please select between 1 and %d: ", types.size());
            System.out.print(prompt);
            final int choice = keyboard.nextInt();
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
            final int choice = keyboard.nextInt();
            if (choice < 1 || choice > condiments.size()) {
                System.out.println("I'm sorry, I did not understand your choice.");
            } else {
                condiment = condiments.get(choice - 1);
            }
        }
        return condiment;
    }

    private int chooseUnits() {
        final Scanner keyboard = new Scanner(System.in);
        final int min = 0;
        final int max = 3;
        int units = -1;
        while (units < min || units > max) {
            System.out.print(String.format("How many units would you like to add to your beverage? [%d-%d] ", min, max));
            units = keyboard.nextInt();
        }
        return units;
    }

    public void brewBeverage() {
        System.out.println("Now dispensing: " + this.beverage);
        this.beverage = null;
    }

}
