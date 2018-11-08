package edu.bu.cs665.service;

import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.Vendor;
import java.util.List;

public class MarketingServiceImpl implements MarketingService {

  @Override
  public void emailCustomers(final List<Customer> customers) {}

  @Override
  public List<Vendor> getPartners() {
    return null;
  }

  @Override
  public List<Customer> getPotentialCustomers() {
    return null;
  }

  @Override
  public List<Customer> getCurrentCustomers() {
    return null;
  }

  @Override
  public List<Customer> getInProgressCustomers() {
    return null;
  }
}
