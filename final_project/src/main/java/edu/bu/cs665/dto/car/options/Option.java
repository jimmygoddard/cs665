package edu.bu.cs665.dto.car.options;

import java.util.UUID;

public interface Option {
  UUID getId();

  String getOptionName();

  String getOptionDescription();

  double getOptionPrice();

  double getTimeToInstall();
}
