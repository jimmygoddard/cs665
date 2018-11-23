package edu.bu.cs665.dto;

import java.util.UUID;

public class ShowTires implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Show tires";
  }

  @Override
  public String getOptionDescription() {
    return "Tires that make your car stand out from the crowd";
  }

  @Override
  public double getOptionPrice() {
    return 4_000.00;
  }

  @Override
  public double getTimeToInstall() {
    return 0;
  }
}
