public class App {

    public static void main(final String[] args) {
        final BeverageMachine machine = new BeverageMachine();
        machine.turnOn();
        while (true) {
            machine.chooseBeverageCategory();
            machine.chooseBeverageType();
            machine.brewBeverage();
        }
    }
}
