package edu.bu.cs665.exception;

public class InvalidMarketingStateException extends Throwable {

  private static final long serialVersionUID = -1584715349579264729L;

  public InvalidMarketingStateException(final String errorMessage) {
    super(errorMessage);
  }

  public InvalidMarketingStateException(final String errorMessage, Throwable e) {
    super(errorMessage, e);
  }
}
