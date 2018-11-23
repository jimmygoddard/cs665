package edu.bu.cs665.dto.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Acura implements CarModel {

  private final Map<String, Double> makeToBasePrice = new HashMap<>();

  public Acura() {
    makeToBasePrice.put("NSX", 140_000.00);
    makeToBasePrice.put("ILX", 30_000.00);
    makeToBasePrice.put("RLX", 55_000.00);
    makeToBasePrice.put("TLX", 45_000.00);
  }

  @Override
  public List<String> getMakes() {
    return new ArrayList<>(makeToBasePrice.keySet());
  }
}
