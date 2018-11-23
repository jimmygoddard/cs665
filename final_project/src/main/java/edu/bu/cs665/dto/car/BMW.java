package edu.bu.cs665.dto.car;

import java.util.Arrays;
import java.util.List;

public class BMW implements CarModel {

  @Override
  public List<String> getMakes() {
    return Arrays.asList("135", "230", "320", "328 Gran Turismo", "528", "750", "M4");
  }
}
