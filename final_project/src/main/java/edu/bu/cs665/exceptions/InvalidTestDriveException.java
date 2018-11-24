package edu.bu.cs665.exceptions;

public class InvalidTestDriveException extends Throwable {

  private static final long serialVersionUID = -4197623897977720155L;

  public InvalidTestDriveException(final String errorMessage) {
    super(errorMessage);
  }
}
