package edu.bu.cs665.resource;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChooserImpl implements Chooser {

  @Override
  public String getSingleChoice(final List<String> choices) {
    final Scanner keyboard = new Scanner(System.in);
    String selection = null;
    while (selection == null) {
      System.out.println("Please choose one of the following:");
      System.out.println();
      for (int i = 0; i < choices.size(); ++i) {
        System.out.println(String.format("\t%d. %s", i + 1, choices.get(i)));
      }
      System.out.println();
      final String prompt = String.format("Please select between 1 and %d: ", choices.size());
      System.out.print(prompt);
      int choice = -1;
      try {
        choice = keyboard.nextInt();
      } catch (final InputMismatchException e) {
        keyboard.reset();
        keyboard.next();
      }
      if (choice < 1 || choice > choices.size()) {
        System.out.println("I'm sorry, I did not understand your choice.");
      } else {
        selection = choices.get(choice - 1);
      }
    }
    return selection;
  }

  @Override
  public List<String> getMultipleChoices(final List<String> choices) {
    final List<String> selections = new ArrayList<>();
    choices.add("done");
    final String selection = getSingleChoice(choices);
    if (selection.equals("done")) {
      return selections;
    }
    selections.add(selection);
    return selections;
  }
}
