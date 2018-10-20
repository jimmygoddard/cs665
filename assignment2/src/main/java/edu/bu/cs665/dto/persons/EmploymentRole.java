package edu.bu.cs665.dto.persons;

public enum EmploymentRole {
  MANAGER,
  FRONT_LINES,
  C_LEVEL;

  public static double getTotalAllowance(final EmploymentRole role) {
    switch (role) {
      case FRONT_LINES:
        return 10_000.00;
      case MANAGER:
        return 20_000.00;
      case C_LEVEL:
        return Double.MAX_VALUE;
    }
    return 0;
  }
}
