package edu.bu.cs665.dto.car.options;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Hyrdaulics implements Option {

  private final UUID id = UUID.randomUUID();
  private final String name = "Hydraulics";
  private final String description = "Hydraulics to trick out your phat car";
  private final double price = 7_500.00;
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
    if (!(o instanceof Hyrdaulics)) {
      return false;
    }
    final Hyrdaulics that = (Hyrdaulics) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Hyrdaulics.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("description='" + description + "'")
        .add("price=$" + price)
        .toString();
  }
}
