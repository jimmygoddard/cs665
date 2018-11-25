package edu.bu.cs665.ui;

import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.exceptions.InvalidCarException;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import edu.bu.cs665.service.CarDealership;
import edu.bu.cs665.service.JimmyCorporation;
import edu.bu.cs665.util.CarGenerator;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import org.fluttercode.datafactory.impl.DataFactory;

public class CarDealershipMenu {
  private static final String INITIALIZE_GARAGE = "Initialize garage";
  private static final String LIST_CARS_MENU_ITEM = "List cars";
  private static final String LIST_RED_CARS_MENU_ITEM = "List red cars";
  private static final String CUSTOMIZE_CAR_MENU_ITEM = "Customize car";
  private static final String PURCHASE_CAR_MENU_ITEM = "Purchase car";
  private static final String LIST_PURCHASED_CARS = "List purchased cars";
  private static final String TEST_DRIVE_CAR_MENU_ITEM = "Test drive car";
  private static final String QUIT_MENU_ITEM = "Quit";

  private final CarDealership carDealership;
  private final Map<String, Runnable> menu = new LinkedHashMap<>();
  private final Chooser chooser = new ChooserImpl();
  private final DataFactory dataFactory = new DataFactory();

  public CarDealershipMenu(final CarDealership carDealership) {
    this.carDealership = carDealership;
    menu.put(INITIALIZE_GARAGE, () -> carDealership.setCars(CarGenerator.generateCars(10)));
    menu.put(
        LIST_CARS_MENU_ITEM,
        () -> {
          final Cars cars = carDealership.getCars();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final Iterator<Car> carIterator = cars.iterator();
          while (carIterator.hasNext()) {
            final Car car = carIterator.next();
            System.out.println(car);
          }
        });
    menu.put(
        LIST_RED_CARS_MENU_ITEM,
        () -> {
          final RedCars redCars = carDealership.getRedCars();
          if (redCars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final Iterator<Car> carIterator = redCars.iterator();
          while (carIterator.hasNext()) {
            final Car redCar = carIterator.next();
            System.out.println(redCar);
          }
        });

    menu.put(
        CUSTOMIZE_CAR_MENU_ITEM,
        () -> {
          final List<Car> cars = carDealership.getCars().toList();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final String id = chooser.getCarChoice(cars);
          System.out.println("Please choose which optional packages you would like for this car");
          final List<String> choices = chooser.getMultipleChoices(carDealership.getOptionNames());
          System.out.println("You have chosen the following packages");
          choices.forEach(System.out::println);
          System.out.println("Customizing car " + id);
          final Car car = carDealership.addOptionsToCar(id, choices);
          System.out.println("Finished customizing car " + car);
        });
    menu.put(
        PURCHASE_CAR_MENU_ITEM,
        () -> {
          final List<Car> cars = carDealership.getCars().toList();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final String id = chooser.getCarChoice(cars);
          System.out.println("Purchasing car " + id);
          final Car car = carDealership.purchaseCar(id);
          System.out.println("Purchased car " + car);
        });
    menu.put(
        LIST_PURCHASED_CARS,
        () -> {
          final List<Car> cars = carDealership.getCars().toList();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final List<Car> purchasedCars = carDealership.getPurchasedCars();
          if (purchasedCars.isEmpty()) {
            System.out.println("No cars have been purchased");
            return;
          }
          purchasedCars.forEach(
              car -> {
                final double totalPrice;
                try {
                  totalPrice = car.getTotalPrice();
                } catch (final InvalidCarException e) {
                  System.err.println(e.getMessage());
                  return;
                }
                final String carString =
                    new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                        .add("carSerialNumber='" + car.getSerialNumber() + "'")
                        .add("carType=" + car.getCarType())
                        .add("totalPrice=$" + totalPrice)
                        .toString();
                System.out.println(carString);
              });
        });

    menu.put(
        TEST_DRIVE_CAR_MENU_ITEM,
        () -> {
          final List<Car> cars = carDealership.getCars().toList();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final String id = chooser.getCarChoice(cars);
          try {
            System.out.println("Test driving car");
            final LocalDate testDriveDate =
                dataFactory
                    .getDate(new Date(), 5, 31)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            final LocalTime testDriveTime = LocalTime.now();
            carDealership.testDrive(id, testDriveDate, testDriveTime);
          } catch (final InvalidTestDriveException e) {
            System.err.println(e.getMessage());
          }
        });
    menu.put(QUIT_MENU_ITEM, () -> {});
  }

  public void run() {
    String choice;
    do {
      System.out.println("Welcome to " + JimmyCorporation.getCorporation());
      System.out.println("Home of the famous dealership " + carDealership);
      choice = chooser.getSingleChoice(new ArrayList<>(menu.keySet()));
      menu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
