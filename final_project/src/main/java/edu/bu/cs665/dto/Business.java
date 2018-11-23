package edu.bu.cs665.dto;

import java.util.UUID;

public interface Business {
  UUID getId();

  String getName();

  String getAddress();

  String getPhoneNumber();
}
