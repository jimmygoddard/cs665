package edu.bu.cs665.dto;

import java.util.Objects;
import java.util.UUID;

public class ElectricEngine implements Option {

  private UUID id = UUID.randomUUID();

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getOptionName() {
    return "Electric engine";
  }

  @Override
  public String getOptionDescription() {
    return "Engine is powered by electricity";
  }

  @Override
  public double getOptionPrice() {
    return 2_000.00;
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
    if (!(o instanceof ElectricEngine)) {
      return false;
    }
    ElectricEngine that = (ElectricEngine) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
