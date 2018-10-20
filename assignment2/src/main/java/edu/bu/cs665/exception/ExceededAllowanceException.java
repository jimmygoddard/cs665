package edu.bu.cs665.exception;

public class ExceededAllowanceException extends Throwable {

  private static final long serialVersionUID = -2327941836384077260L;

  public ExceededAllowanceException(final String errorMessage) {
    super(errorMessage);
  }

  public ExceededAllowanceException(final String errorMessage, final Throwable e) {
    super(errorMessage, e);
  }
}
