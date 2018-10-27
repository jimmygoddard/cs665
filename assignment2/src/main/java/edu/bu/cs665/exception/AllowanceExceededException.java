package edu.bu.cs665.exception;

public class AllowanceExceededException extends Throwable {

  private static final long serialVersionUID = -2327941836384077260L;

  public AllowanceExceededException(final String errorMessage) {
    super(errorMessage);
  }

  public AllowanceExceededException(final String errorMessage, final Throwable e) {
    super(errorMessage, e);
  }
}
