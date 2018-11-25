package edu.bu.cs665.dto.car.options;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class DetailedPaintJob implements Option {

  private final UUID id = UUID.randomUUID();
  private final String name = "Racing paint job";
  private final String description = "Sharp detailing and custom paint as they do with GT racing";
  private final double price = 5_000.00;
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
    if (!(o instanceof DetailedPaintJob)) {
      return false;
    }
    final DetailedPaintJob that = (DetailedPaintJob) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DetailedPaintJob.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("description='" + description + "'")
        .add("price=$" + price)
        .toString();
  }
}
