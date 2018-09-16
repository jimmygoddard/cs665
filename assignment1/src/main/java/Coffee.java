import java.util.Arrays;
import java.util.List;

public class Coffee implements Beverage {

    private String type;
    private int milkUnits = 0;
    private int sugarUnits = 0;

    public int getMilkUnits() {
        return milkUnits;
    }

    public void setMilkUnits(final int milkUnits) {
        if (milkUnits < 0 || milkUnits > 3) {
            throw new IllegalArgumentException("Coffee can only take between 0 and 3 units of milk");
        }
        this.milkUnits = milkUnits;
    }

    public int getSugarUnits() {
        return sugarUnits;
    }

    public void setSugarUnits(final int sugarUnits) {
        if (sugarUnits < 0 || sugarUnits > 3) {
            throw new IllegalArgumentException("Coffee can only take between 0 and 3 units of sugar");
        }
        this.sugarUnits = sugarUnits;
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
        this.type = type;
    }

    private String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format(
                "%s coffee with %d units of milk and %d units of sugar.",
                getType(),
                getMilkUnits(),
                getSugarUnits());
    }
}
