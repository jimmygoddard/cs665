package edu.bu.cs665.dto.car.options;

import java.util.Objects;
import java.util.UUID;

public class PerformanceEngine implements Option {

  private final UUID id = UUID.randomUUID();
  private final String name = "Performance engine";
  private final String description = "Optimizations to the engine to increase performance";
  private final double price = 10_000.00;
  private final double timeToInstall = 0;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return name;
  }

  @Override
  public String getOptionDescription() {
    return description;
  }

  @Override
  public double getOptionPrice() {
    return price;
  }

  @Override
  public double getTimeToInstall() {
    return timeToInstall;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PerformanceEngine)) {
      return false;
    }
    final PerformanceEngine that = (PerformanceEngine) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "PerformanceEngine{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", price="
        + price
        + ", timeToInstall="
        + timeToInstall
        + '}';
  }
}
