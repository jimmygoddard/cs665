package edu.bu.cs665.exceptions;

public class InvalidCarException extends Throwable {

  private static final long serialVersionUID = 1499689224424098979L;

  public InvalidCarException(final String errorMessage) {
    super(errorMessage);
  }
}
