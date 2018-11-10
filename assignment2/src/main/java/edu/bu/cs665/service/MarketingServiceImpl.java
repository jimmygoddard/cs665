package edu.bu.cs665.service;

import edu.bu.cs665.dao.CustomerStoreImpl;
import edu.bu.cs665.dao.VendorStoreImpl;
import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.CustomerStatus;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.exception.InvalidMarketingStateException;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingServiceImpl implements MarketingService {
  private final CustomerService customerService =
      new CustomerServiceImpl(CustomerStoreImpl.getCustomerStore());
  private final VendorService vendorService =
      new VendorServiceImpl(VendorStoreImpl.getVendorStore());

  private static final String CREATE_CUSTOMERS_MESSAGE =
      "No customers exist.  Please use the Accounting module to add customers.";
  private static final String CREATE_VENDORS_MESSAGE =
      "No vendors exist.  Please use the Accounting module to add vendors.";

  private void checkCustomers() throws InvalidMarketingStateException {
    if (customerService.getCustomers().isEmpty()) {
      throw new InvalidMarketingStateException(CREATE_CUSTOMERS_MESSAGE);
    }
  }

  private void checkVendors() throws InvalidMarketingStateException {
    if (vendorService.getVendors().isEmpty()) {
      throw new InvalidMarketingStateException(CREATE_VENDORS_MESSAGE);
    }
  }

  @Override
  public List<String> emailCustomers() throws InvalidMarketingStateException {
    checkCustomers();
    return getPotentialCustomers().stream().map(Customer::getEmail).collect(Collectors.toList());
  }

  @Override
  public List<Vendor> getPartners() throws InvalidMarketingStateException {
    checkVendors();
    return vendorService
        .getVendors()
        .stream()
        .filter(Vendor::isPartner)
        .collect(Collectors.toList());
  }

  @Override
  public List<Customer> getPotentialCustomers() throws InvalidMarketingStateException {
    checkCustomers();
    return customerService
        .getCustomers()
        .stream()
        .filter(customer -> customer.getCustomerStatus().equals(CustomerStatus.POTENTIAL))
        .collect(Collectors.toList());
  }

  @Override
  public List<Customer> getCurrentCustomers() throws InvalidMarketingStateException {
    checkCustomers();
    return customerService
        .getCustomers()
        .stream()
        .filter(customer -> customer.getCustomerStatus().equals(CustomerStatus.CURRENT))
        .collect(Collectors.toList());
  }

  @Override
  public List<Customer> getInProgressCustomers() throws InvalidMarketingStateException {
    checkCustomers();
    return customerService
        .getCustomers()
        .stream()
        .filter(customer -> customer.getCustomerStatus().equals(CustomerStatus.CONTACTED))
        .collect(Collectors.toList());
  }

  @Override
  public List<Customer> getRejectedCustomers() throws InvalidMarketingStateException {
    checkCustomers();
    return customerService
        .getCustomers()
        .stream()
        .filter(customer -> customer.getCustomerStatus().equals(CustomerStatus.REJECTED))
        .collect(Collectors.toList());
  }
}
