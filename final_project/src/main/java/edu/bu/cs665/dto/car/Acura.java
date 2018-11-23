package edu.bu.cs665.dto.car;

import java.util.Arrays;
import java.util.List;

public class Acura implements CarModel {

  @Override
  public List<String> getMakes() {
    return Arrays.asList("NSX", "ILX", "RLX", "TL");
  }
}
