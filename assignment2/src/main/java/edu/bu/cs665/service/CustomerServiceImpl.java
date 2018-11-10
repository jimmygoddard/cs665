package edu.bu.cs665.service;

import edu.bu.cs665.dao.CustomerStore;
import edu.bu.cs665.dto.Customer;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

  private final CustomerStore customerStore;

  public CustomerServiceImpl(final CustomerStore customerStore) {
    this.customerStore = customerStore;
  }

  @Override
  public List<Customer> getCustomers() {
    return customerStore.getCustomers();
  }

  @Override
  public void setCustomers(final List<Customer> customers) {
    customerStore.setCustomers(customers);
  }

  @Override
  public void addCustomers(List<Customer> customers) {
    customerStore.getCustomers().addAll(customers);
  }
}
