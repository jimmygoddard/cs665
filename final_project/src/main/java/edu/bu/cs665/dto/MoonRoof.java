package edu.bu.cs665.dto;

import java.util.Objects;
import java.util.UUID;

public class MoonRoof implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Moon roof";
  }

  @Override
  public String getOptionDescription() {
    return "Moon roof";
  }

  @Override
  public double getOptionPrice() {
    return 1_000.00;
  }

  @Override
  public double getTimeToInstall() {
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MoonRoof)) {
      return false;
    }
    MoonRoof moonRoof = (MoonRoof) o;
    return Objects.equals(id, moonRoof.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
