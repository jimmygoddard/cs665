package edu.bu.cs665.exceptions;

public class InvalidCarMake extends Throwable {

  private static final long serialVersionUID = 1499689224424098979L;

  public InvalidCarMake(final String errorMessage) {
    super(errorMessage);
  }
}
