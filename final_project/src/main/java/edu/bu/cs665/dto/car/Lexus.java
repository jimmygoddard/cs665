package edu.bu.cs665.dto.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexus implements CarModel {

  private final Map<String, Double> makeToPrice = new HashMap<>();

  public Lexus() {
    makeToPrice.put("ES 350", 52_000.00);
    makeToPrice.put("GS 350", 59_000.00);
    makeToPrice.put("IS 300", 45_000.00);
    makeToPrice.put("LS 500", 86_000.00);
  }

  @Override
  public List<String> getMakes() {
    return new ArrayList<>(makeToPrice.keySet());
  }
}
