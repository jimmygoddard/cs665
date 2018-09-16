import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class BeverageMachineTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void turnOn() {
        final BeverageMachine machine = new BeverageMachine();
        machine.turnOn();
        // Include platform specific newline character using %n
        final String expected = String.format("Welcome to the Fully Automatic Beverage Vending Machine!%n");
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void chooseBeverageCategory() {
        final BeverageMachine machine = new BeverageMachine();
        final String expected = "tea";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        machine.chooseBeverageCategory();
        Assert.assertEquals(expected, machine.dispense().getDescriptor());
    }

    @Test
    public void brewBeverage() {
        final BeverageMachine machine = new BeverageMachine();
        machine.brewBeverage();
        Assert.assertTrue(outContent.toString().startsWith("Now dispensing: "));
    }
}