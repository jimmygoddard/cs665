package edu.bu.cs665.exception;

public class BalanceExceededException extends Throwable {

  private static final long serialVersionUID = 1816218067921295155L;

  public BalanceExceededException(final String errorMessage) {
    super(errorMessage);
  }

  public BalanceExceededException(final String errorMessage, final Throwable e) {
    super(errorMessage, e);
  }
}
