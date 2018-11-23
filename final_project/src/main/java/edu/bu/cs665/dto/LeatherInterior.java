package edu.bu.cs665.dto;

import java.util.UUID;

public class LeatherInterior implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Leather interior";
  }

  @Override
  public String getOptionDescription() {
    return "Leather seats and interior trim";
  }

  @Override
  public double getOptionPrice() {
    return 10_000.00;
  }

  @Override
  public double getTimeToInstall() {
    return 0;
  }
}
