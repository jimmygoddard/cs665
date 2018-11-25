package edu.bu.cs665.resource;

import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import edu.bu.cs665.service.CarDealership;
import edu.bu.cs665.service.JimmyCorporation;
import edu.bu.cs665.util.CarGenerator;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.fluttercode.datafactory.impl.DataFactory;

public class CarDealershipResource {
  private static final String CREATE_CARS_MENU_ITEM = "Create cars";
  private static final String LIST_CARS_MENU_ITEM = "List cars";
  private static final String LIST_RED_CARS_MENU_ITEM = "List red cars";
  private static final String CUSTOMIZE_CAR_MENU_ITEM = "Customize car";
  private static final String TEST_DRIVE_CAR_MENU_ITEM = "Test drive car";
  private static final String QUIT_MENU_ITEM = "Quit";

  private CarDealership carDealership = JimmyCorporation.getCorporation().getCarDealership();
  private final Map<String, Runnable> menu = new LinkedHashMap<>();
  private final Chooser chooser = new ChooserImpl();
  private final DataFactory dataFactory = new DataFactory();

  public CarDealershipResource() {
    menu.put(CREATE_CARS_MENU_ITEM, () -> carDealership.setCars(CarGenerator.generateCars(10)));
    menu.put(
        LIST_CARS_MENU_ITEM,
        () -> {
          final Cars cars = new Cars(carDealership.getCars());
          final Iterator<Car> carIterator = cars.iterator();
          while (carIterator.hasNext()) {
            final Car car = carIterator.next();
            System.out.println(car);
          }
        });
    menu.put(
        LIST_RED_CARS_MENU_ITEM,
        () -> {
          final RedCars redCars = new RedCars(carDealership.getCars());
          final Iterator<Car> carIterator = redCars.iterator();
          while (carIterator.hasNext()) {
            final Car redCar = carIterator.next();
            System.out.println(redCar);
          }
        });

    menu.put(CUSTOMIZE_CAR_MENU_ITEM, () -> {});
    menu.put(
        TEST_DRIVE_CAR_MENU_ITEM,
        () -> {
          final String id = chooser.getCarChoice(carDealership.getCars());
          try {
            System.out.println("Test driving car");
            carDealership.testDrive(
                id,
                dataFactory
                    .getDate(new Date(), 5, 31)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate(),
                LocalTime.now());
          } catch (final InvalidTestDriveException e) {
            System.out.println(e.getMessage());
          }
        });
    menu.put(QUIT_MENU_ITEM, () -> {});
  }

  public CarDealershipResource(final CarDealership carDealership) {
    this();
    this.carDealership = carDealership;
  }

  public void run() {
    String choice;
    do {
      choice = chooser.getSingleChoice(new ArrayList<>(menu.keySet()));
      menu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
