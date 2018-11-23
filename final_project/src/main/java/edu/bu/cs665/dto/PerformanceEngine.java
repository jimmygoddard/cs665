package edu.bu.cs665.dto;

import java.util.Objects;
import java.util.UUID;

public class PerformanceEngine implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Performance engine";
  }

  @Override
  public String getOptionDescription() {
    return "Optimizations to the engine to increase performance";
  }

  @Override
  public double getOptionPrice() {
    return 10_000.00;
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
    if (!(o instanceof PerformanceEngine)) {
      return false;
    }
    PerformanceEngine that = (PerformanceEngine) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
