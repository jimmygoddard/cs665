package edu.bu.cs665.dto;

import java.util.UUID;

public class DetailedPaintJob implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Custom paint job";
  }

  @Override
  public String getOptionDescription() {
    return "Sharp detailing and custom paint";
  }

  @Override
  public double getOptionPrice() {
    return 5_000.00;
  }

  @Override
  public double getTimeToInstall() {
    return 0;
  }
}
