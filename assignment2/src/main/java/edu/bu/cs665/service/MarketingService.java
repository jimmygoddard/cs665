package edu.bu.cs665.service;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.exception.InvalidMarketingStateException;
import java.util.List;

public interface MarketingService {

  List<String> emailCustomers() throws InvalidMarketingStateException;

  List<Vendor> getPartners() throws InvalidMarketingStateException;

  List<Customer> getPotentialCustomers() throws InvalidMarketingStateException;

  List<Customer> getCurrentCustomers() throws InvalidMarketingStateException;

  List<Customer> getInProgressCustomers() throws InvalidMarketingStateException;

  List<Customer> getRejectedCustomers() throws InvalidMarketingStateException;
}
