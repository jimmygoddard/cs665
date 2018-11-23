package edu.bu.cs665.dto;

import java.util.Objects;
import java.util.UUID;

public class GasEngine implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Gas engine";
  }

  @Override
  public String getOptionDescription() {
    return "Engine is powered by gas combustion";
  }

  @Override
  public double getOptionPrice() {
    return 0;
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
    if (!(o instanceof GasEngine)) {
      return false;
    }
    GasEngine gasEngine = (GasEngine) o;
    return Objects.equals(id, gasEngine.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
