package edu.bu.cs665.dto.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BMW implements CarModel {

  private final Map<String, Double> makeToPrice = new HashMap<>();

  public BMW() {
    makeToPrice.put("230", 50_000.00);
    makeToPrice.put("320", 43_000.00);
    makeToPrice.put("330 Gran Turismo", 50_100.00);
    makeToPrice.put("540", 65_000.00);
    makeToPrice.put("750", 105_000.00);
    makeToPrice.put("M4", 115_000.00);
  }

  @Override
  public List<String> getMakes() {
    return new ArrayList<>(makeToPrice.keySet());
  }

  @Override
  public double getBasePrice(final String carMake) {
    return makeToPrice.get(carMake);
  }

  @Override
  public String toString() {
    return "BMW";
  }
}
