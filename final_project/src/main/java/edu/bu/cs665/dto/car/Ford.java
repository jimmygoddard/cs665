package edu.bu.cs665.dto.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ford implements CarModel {

  private final Map<String, Double> makeToPrice = new HashMap<>();

  public Ford() {
    makeToPrice.put("Edge", 41_000.00);
    makeToPrice.put("Expedition", 70_000.00);
    makeToPrice.put("F-150", 55_000.00);
    makeToPrice.put("Focus", 19_000.00);
    makeToPrice.put("Mustang", 50_000.00);
    makeToPrice.put("Shelby GT350", 62_000.00);
  }

  @Override
  public List<String> getMakes() {
    return new ArrayList<>(makeToPrice.keySet());
  }

  @Override
  public double getBasePrice(final String carMake) {
    return makeToPrice.get(carMake);
  }
}
