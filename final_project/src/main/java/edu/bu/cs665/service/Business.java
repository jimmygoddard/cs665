package edu.bu.cs665.service;

import java.util.UUID;

public interface Business {

  /**
   * Get the business' id
   *
   * @return the id of the business
   */
  UUID getId();

  /**
   * Get the business' name
   *
   * @return the name of the business
   */
  String getName();

  /**
   * Get the business' address
   *
   * @return the address of the business
   */
  String getAddress();

  /**
   * Get the business' phone number
   *
   * @return the phone number of the business
   */
  String getPhoneNumber();
}
