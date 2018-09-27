import java.util.Arrays;
import java.util.List;

public class Coffee implements Beverage {

  private String type;
  private int milkUnits = 0;
  private int sugarUnits = 0;
  private final int min = 0;
  private final int max = 3;

  /**
   * Retrieve the number of milks added to the coffee;
   *
   * @return number of milks
   */
  public int getMilkUnits() {
    return milkUnits;
  }

  /**
   * Add milk to the coffee
   *
   * @param milkUnits number of milks to add
   */
  public void setMilkUnits(final int milkUnits) {
    if (milkUnits < this.min || milkUnits > this.max) {
      throw new IllegalArgumentException(
          String.format(
              "Coffee can only take between %d and %d units of milk", this.min, this.max));
    }
    this.milkUnits = milkUnits;
  }

  /**
   * Retrieve the number of sugars added to the coffee
   *
   * @return number of sugars added
   */
  public int getSugarUnits() {
    return sugarUnits;
  }

  /**
   * Add sugar to the coffee
   *
   * @param sugarUnits number of sugars to add
   */
  public void setSugarUnits(final int sugarUnits) {
    if (sugarUnits < this.min || sugarUnits > this.max) {
      throw new IllegalArgumentException(
          String.format(
              "Coffee can only take between %d and %d units of sugar", this.min, this.max));
    }
    this.sugarUnits = sugarUnits;
  }

  /**
   * Minimum number of milk or sugar which can be added to the coffee
   *
   * @return minimum number of condiment units
   */
  public int getMin() {
    return this.min;
  }

  /**
   * Maximum number of milk or sugar which can be added to the coffee
   *
   * @return maximum number of condiment units
   */
  public int getMax() {
    return this.max;
  }

  @Override
  public String getDescriptor() {
    return "coffee";
  }

  @Override
  public List<String> getTypes() {
    return Arrays.asList("americano", "espresso", "latte machiato");
  }

  @Override
  public void setType(final String type) {
    if (!getTypes().contains(type)) {
      throw new IllegalArgumentException("Type must be one of " + getTypes());
    }
    this.type = type;
  }

  private String getType() {
    return this.type;
  }

  @Override
  public String toString() {
    return String.format(
        "%s coffee with %d units of milk and %d units of sugar.",
        getType(), getMilkUnits(), getSugarUnits());
  }
}
