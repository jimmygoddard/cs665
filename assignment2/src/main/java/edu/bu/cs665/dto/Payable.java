package edu.bu.cs665.dto;

import edu.bu.cs665.exception.ExceededAllowanceException;

public interface Payable {
  double getBalance();

  double payBalance(double payment) throws ExceededAllowanceException;
}
