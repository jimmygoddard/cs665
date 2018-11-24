package edu.bu.cs665.dto.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dodge implements CarModel {

  private final Map<String, Double> makeToPrice = new HashMap<>();

  public Dodge() {
    makeToPrice.put("Challenger", 29_000.00);
    makeToPrice.put("Charger", 36_000.00);
    makeToPrice.put("Durango", 42_000.00);
    makeToPrice.put("Grand Caravan", 23_000.00);
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
