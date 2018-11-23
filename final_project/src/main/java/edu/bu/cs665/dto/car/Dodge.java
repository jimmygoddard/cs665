package edu.bu.cs665.dto.car;

import java.util.Arrays;
import java.util.List;

public class Dodge implements CarModel {

  @Override
  public List<String> getMakes() {
    return Arrays.asList("Avenger", "Viper", "Charger", "Ram");
  }
}
