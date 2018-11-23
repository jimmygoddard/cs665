package edu.bu.cs665.dto.car;

import java.util.Arrays;
import java.util.List;

public class Ford implements CarModel {

  @Override
  public List<String> getMakes() {
    return Arrays.asList("Crown Victoria", "Edge", "Expedition", "F-150", "Focus", "Mustang", "Shelby GT350");
  }
}
