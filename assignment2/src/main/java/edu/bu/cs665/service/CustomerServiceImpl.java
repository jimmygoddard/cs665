package edu.bu.cs665.service;

import edu.bu.cs665.dao.CustomerStore;
import edu.bu.cs665.dto.Customer;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

  private final CustomerStore m_customerStore;

  public CustomerServiceImpl(final CustomerStore customerStore) {
    m_customerStore = customerStore;
  }

  @Override
  public List<Customer> getCustomers() {
    return m_customerStore.getCustomers();
  }

  @Override
  public void setCustomers(final List<Customer> customers) {
    m_customerStore.setCustomers(customers);
  }
}
