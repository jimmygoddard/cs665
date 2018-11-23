package edu.bu.cs665.dto.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Audi implements CarModel {

  private final Map<String, Double> makeToPrice = new HashMap<>();

  public Audi() {
    makeToPrice.put("A3", 43_000.00);
    makeToPrice.put("TTS", 57_000.00);
    makeToPrice.put("A4", 50_000.00);
    makeToPrice.put("Q7", 73_000.00);
    makeToPrice.put("R8", 207_000.00);
  }

  @Override
  public List<String> getMakes() {
    return new ArrayList<>(makeToPrice.keySet());
  }
}
