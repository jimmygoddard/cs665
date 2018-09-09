public class Coffee implements Beverage {

    private CoffeeType coffeeType;
    private int milkUnits = 0;
    private int sugarUnits = 0;

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(final CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

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
    public void prepare() {
        System.out.println("You chose: " + this);
    }

    @Override
    public String toString() {
        return String.format(
                "%s coffee with %d units of milk and %d units of sugar.",
                getCoffeeType().toString().toLowerCase(),
                getMilkUnits(),
                getSugarUnits());
    }
}
