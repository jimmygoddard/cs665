package edu.bu.cs665.resource;

import edu.bu.cs665.dto.Cars;
import edu.bu.cs665.dto.RedCars;
import edu.bu.cs665.dto.car.Car;
import edu.bu.cs665.dto.car.options.DetailedPaintJob;
import edu.bu.cs665.dto.car.options.ElectricEngine;
import edu.bu.cs665.dto.car.options.GasEngine;
import edu.bu.cs665.dto.car.options.Hyrdaulics;
import edu.bu.cs665.dto.car.options.LeatherInterior;
import edu.bu.cs665.dto.car.options.MoonRoof;
import edu.bu.cs665.dto.car.options.Option;
import edu.bu.cs665.dto.car.options.PerformanceEngine;
import edu.bu.cs665.dto.car.options.Turbo;
import edu.bu.cs665.dto.car.options.UpgradeTires;
import edu.bu.cs665.exceptions.InvalidTestDriveException;
import edu.bu.cs665.service.CarDealership;
import edu.bu.cs665.util.CarGenerator;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import org.fluttercode.datafactory.impl.DataFactory;

public class CarDealershipResource {
  private static final String CREATE_CARS_MENU_ITEM = "Create cars";
  private static final String LIST_CARS_MENU_ITEM = "List cars";
  private static final String LIST_RED_CARS_MENU_ITEM = "List red cars";
  private static final String CUSTOMIZE_CAR_MENU_ITEM = "Customize car";
  private static final String PURCHASE_CAR_MENU_ITEM = "Purchase car";
  private static final String TEST_DRIVE_CAR_MENU_ITEM = "Test drive car";
  private static final String QUIT_MENU_ITEM = "Quit";

  private final Map<String, Runnable> menu = new LinkedHashMap<>();
  private final Chooser chooser = new ChooserImpl();
  private final DataFactory dataFactory = new DataFactory();

  private final List<Option> options =
      Arrays.asList(
          new DetailedPaintJob(),
          new ElectricEngine(),
          new GasEngine(),
          new Hyrdaulics(),
          new LeatherInterior(),
          new MoonRoof(),
          new PerformanceEngine(),
          new UpgradeTires(),
          new Turbo());

  public CarDealershipResource(final CarDealership carDealership) {
    menu.put(CREATE_CARS_MENU_ITEM, () -> carDealership.setCars(CarGenerator.generateCars(10)));
    menu.put(
        LIST_CARS_MENU_ITEM,
        () -> {
          final Cars cars = new Cars(carDealership.getCars());
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
          final RedCars redCars = new RedCars(carDealership.getCars());
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
          final List<Car> cars = carDealership.getCars();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final String id = chooser.getCarChoice(cars);
          System.out.println("Please choose which optional packages you would like for this car");
          final List<String> optionNames =
              chooser.getMultipleChoices(
                  options.stream().map(Option::getOptionName).collect(Collectors.toList()));
          System.out.println("You have chosen the following packages");
          optionNames.forEach(System.out::println);
          System.out.println("Customizing car " + id);
          final List<Option> packages =
              optionNames
                  .stream()
                  .map(
                      name ->
                          options
                              .stream()
                              .filter(option -> option.getOptionName().equals(name))
                              .findFirst()
                              .orElse(null))
                  .filter(Objects::nonNull)
                  .collect(Collectors.toList());
          final Car car = carDealership.addOptionsToCar(UUID.fromString(id), options);
          System.out.println("Finished customizing car " + car);
        });
    menu.put(
        PURCHASE_CAR_MENU_ITEM,
        () -> {
          final List<Car> cars = carDealership.getCars();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final String id = chooser.getCarChoice(cars);
          System.out.println("Purchasing car " + id);
          final Car car = carDealership.purchaseCar(UUID.fromString(id));
          System.out.println("Purchased car " + car);
        });
    menu.put(
        TEST_DRIVE_CAR_MENU_ITEM,
        () -> {
          final List<Car> cars = carDealership.getCars();
          if (cars.isEmpty()) {
            System.out.println("No cars to list.  Please create a list of cars");
            return;
          }
          final String id = chooser.getCarChoice(cars);
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

  public void run() {
    String choice;
    do {
      choice = chooser.getSingleChoice(new ArrayList<>(menu.keySet()));
      menu.get(choice).run();
    } while (!choice.equals(QUIT_MENU_ITEM));
  }
}
