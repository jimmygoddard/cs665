package edu.bu.cs665.dto;

import java.util.UUID;

public interface Option {
  UUID getId();
  String getOptionName();
  String getOptionDescription();
  double getOptionPrice();
  double getTimeToInstall();
}
