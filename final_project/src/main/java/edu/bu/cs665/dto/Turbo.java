package edu.bu.cs665.dto;

import java.util.Objects;
import java.util.UUID;

public class Turbo implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Turbo injection";
  }

  @Override
  public String getOptionDescription() {
    return "Increases acceleration";
  }

  @Override
  public double getOptionPrice() {
    return 5_000.00;
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
    if (!(o instanceof Turbo)) {
      return false;
    }
    Turbo turbo = (Turbo) o;
    return Objects.equals(id, turbo.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
