package edu.bu.cs665.dto.car;

import java.util.Arrays;
import java.util.List;

public class Audi implements CarModel {

  @Override
  public List<String> getMakes() {
    return Arrays.asList("A3", "TT", "A4", "Q7", "R8");
  }
}
