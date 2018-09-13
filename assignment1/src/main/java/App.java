import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static Beverage chooseBeverageCategory() {
        // FIXME catch InputMismatchException
        final Scanner keyboard = new Scanner(System.in);
        Beverage beverage = null;
        while (beverage == null) {
            System.out.print("Would you like to make coffee or tea? ");
            final String choice = keyboard.nextLine();
            switch (choice) {
                case "tea":
                    beverage = new Tea();
                    break;
                case "coffee":
                    beverage = new Coffee();
                    break;
                default:
                    System.out.println("I'm sorry, I did not understand your choice. Please type 'coffee' or 'tea'.");
            }
        }
        return beverage;
    }

    public static <T> T chooseBeverageType(final T[] types, final String descriptor) {
        final Scanner keyboard = new Scanner(System.in);
        T type = null;
        while (type == null) {
            System.out.println(String.format("What type of %s would you like?", descriptor));
            System.out.println();
            for (int i = 0; i < types.length; ++i) {
                System.out.println(String.format("\t%d. %s", i + 1, types[i]).toLowerCase());
            }
            System.out.println();
            final String prompt = String.format("Please select between 1 and %d: ", types.length);
            System.out.print(prompt);
            final int choice = keyboard.nextInt();
            if (choice < 1 || choice > types.length) {
                System.out.println("I'm sorry, I did not understand your choice.");
            } else {
                type = types[choice - 1];
            }
        }
        return type;
    }

    public static String chooseCondiment(final List<String> condiments) {
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

    public static int chooseUnits() {
        final Scanner keyboard = new Scanner(System.in);
        int units = -1;
        while (units < 0 || units > 3) {
            System.out.print("How many units would you like to add to your beverage? [0-3] ");
            units = keyboard.nextInt();
        }
        return units;
    }

    public static void main(final String[] args) {
        System.out.println("Welcome to the Fully Automatic Beverage Vending Machine!");
        while (true) {
            final Beverage beverage = chooseBeverageCategory();
            if (beverage instanceof Coffee) {
                final CoffeeType coffeeType = chooseBeverageType(CoffeeType.values(), "coffee");
                ((Coffee) beverage).setCoffeeType(coffeeType);
                final List<String> choices = Arrays.asList("milk", "sugar", "done");
                String condiment = "";
                while (!condiment.equals("done")) {
                    condiment = chooseCondiment(choices);
                    switch (condiment) {
                        case "milk":
                            final int milkUnits = chooseUnits();
                            ((Coffee) beverage).setMilkUnits(milkUnits);
                            break;
                        case "sugar":
                            final int sugarUnits = chooseUnits();
                            ((Coffee) beverage).setSugarUnits(sugarUnits);
                    }
                }
            } else if (beverage instanceof Tea) {
                final TeaType teaType = chooseBeverageType(TeaType.values(), "tea");
                ((Tea) beverage).setTeaType(teaType);
            }
            beverage.prepare();
        }
    }
}
