package edu.bu.cs665.exception;

public class EmployeeNotFoundException extends Exception {

  private static final long serialVersionUID = 3245066704790607780L;

  public EmployeeNotFoundException(final String errorMessage) {
    super(errorMessage);
  }

  public EmployeeNotFoundException(String errorMessage, Throwable e) {
    super(errorMessage, e);
  }
}
