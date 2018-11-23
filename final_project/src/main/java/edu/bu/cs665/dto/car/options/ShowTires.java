package edu.bu.cs665.dto.car.options;

import java.util.Objects;
import java.util.UUID;

public class ShowTires implements Option {

  private final UUID id = UUID.randomUUID();
  private final String name = "Show tires";
  private final String description = "Tires that make your car stand out from the crowd";
  private final double price = 4_000.00;
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
    if (!(o instanceof ShowTires)) {
      return false;
    }
    final ShowTires showTires = (ShowTires) o;
    return Objects.equals(id, showTires.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ShowTires{"
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
