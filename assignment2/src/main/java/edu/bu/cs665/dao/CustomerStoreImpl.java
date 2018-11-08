package edu.bu.cs665.dao;

import edu.bu.cs665.dto.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerStoreImpl implements CustomerStore {

  private List<Customer> m_customers = new ArrayList<>();

  private CustomerStoreImpl() {}

  private static class CustomerStoreImplHolder {
    private static final CustomerStore instance = new CustomerStoreImpl();
  }

  public static CustomerStore getCustomerStore() {
    return CustomerStoreImplHolder.instance;
  }

  @Override
  public List<Customer> getCustomers() {
    return m_customers;
  }

  @Override
  public void setCustomers(final List<Customer> customers) {
    m_customers = customers;
  }
}
