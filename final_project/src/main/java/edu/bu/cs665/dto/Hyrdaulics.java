package edu.bu.cs665.dto;

import java.util.UUID;

public class Hyrdaulics implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Hydraulics";
  }

  @Override
  public String getOptionDescription() {
    return "Hydraulics to trick out your phat car";
  }

  @Override
  public double getOptionPrice() {
    return 7_500.00;
  }

  @Override
  public double getTimeToInstall() {
    return 0;
  }
}
