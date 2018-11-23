package edu.bu.cs665.dto.car;

import java.util.Arrays;
import java.util.List;

public class Lexus implements CarModel {

  @Override
  public List<String> getMakes() {
    return Arrays.asList("CT 200h", "ES 300", "HS 250h", "IS 250", "LS 500");
  }
}
