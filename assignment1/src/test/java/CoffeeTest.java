import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CoffeeTest {

    @Test
    public void setSugarUnits() {
        final Coffee coffee = new Coffee();
        for (int i = 0; i < 4; ++i) {
            coffee.setSugarUnits(i);
            Assert.assertEquals(i, coffee.getSugarUnits());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSugarUnitsTestThrowOnLowInput() {
        final Coffee coffee = new Coffee();
        coffee.setSugarUnits(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSugarUnitsTestThrowOnHighInput() {
        final Coffee coffee = new Coffee();
        coffee.setSugarUnits(4);
    }

    @Test
    public void getDescriptor() {
        final Coffee coffee = new Coffee();
        Assert.assertEquals("coffee", coffee.getDescriptor());
    }

    @Test
    public void getTypes() {
        final Coffee coffee = new Coffee();
        Assert.assertEquals(Arrays.asList("americano", "espresso", "latte machiato"), coffee.getTypes());
    }

    @Test
    public void setMilkUnits() {
        final Coffee coffee = new Coffee();
        for (int i = 0; i < 4; ++i) {
            coffee.setMilkUnits(i);
            Assert.assertEquals(i, coffee.getMilkUnits());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMilkUnitsTestThrowOnLowInput() {
        final Coffee coffee = new Coffee();
        coffee.setMilkUnits(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMilkUnitsTestThrowOnHighInput() {
        final Coffee coffee = new Coffee();
        coffee.setMilkUnits(4);
    }

}