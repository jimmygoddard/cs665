package edu.bu.cs665.service;

import edu.bu.cs665.dao.CustomerStoreImpl;
import edu.bu.cs665.dao.VendorStoreImpl;
import edu.bu.cs665.dto.Customer;
import edu.bu.cs665.dto.CustomerStatus;
import edu.bu.cs665.dto.Vendor;
import edu.bu.cs665.exception.InvalidMarketingStateException;
import edu.bu.cs665.util.CustomerGenerator;
import edu.bu.cs665.util.VendorGenerator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MarketingServiceImplTest {
  private final MarketingService marketingService = new MarketingServiceImpl();
  private final CustomerService customerService =
      new CustomerServiceImpl(CustomerStoreImpl.getCustomerStore());
  private final VendorService vendorService =
      new VendorServiceImpl(VendorStoreImpl.getVendorStore());
  private final DataFactory datafactory = new DataFactory();

  /**
   * Make sure the VendorStore and CustomerStore are populated with random vendors and customers
   * respectively
   */
  @Before
  public void setUp() {
    customerService.setCustomers(CustomerGenerator.generateCustomers(10));
    vendorService.setVendors(VendorGenerator.generateVendors(10));
  }

  /**
   * Set all customers to rejected state. Set a few selected customers to potential state with
   * specific email addresses. Verify that these are the customers that are returned by the
   * MarketingService
   *
   * @throws InvalidMarketingStateException if the CustomerStore is empty
   */
  @Test
  public void emailCustomers() throws InvalidMarketingStateException {
    final List<Customer> customers = customerService.getCustomers();
    customers.forEach(customer -> customer.setCustomerStatus(CustomerStatus.REJECTED));
    customers.get(1).setCustomerStatus(CustomerStatus.POTENTIAL);
    customers.get(1).setEmail(datafactory.getEmailAddress());
    customers.get(5).setCustomerStatus(CustomerStatus.POTENTIAL);
    customers.get(5).setEmail(datafactory.getEmailAddress());
    customers.get(7).setCustomerStatus(CustomerStatus.POTENTIAL);
    customers.get(7).setEmail(datafactory.getEmailAddress());

    final List<String> expectedEmails =
        Arrays.asList(
            customers.get(1).getEmail(), customers.get(5).getEmail(), customers.get(7).getEmail());
    final List<String> actualEmails = marketingService.emailCustomers();
    Assert.assertEquals(expectedEmails, actualEmails);
  }

  /**
   * Set all vendors to not be partners. Then set a select few to be partners. Verify that the
   * MarketingService returns these partner vendors
   *
   * @throws InvalidMarketingStateException if the VendorStore is empty
   */
  @Test
  public void getPartners() throws InvalidMarketingStateException {
    final List<Vendor> vendors = vendorService.getVendors();
    vendors.forEach(vendor -> vendor.isPartner(false));
    vendors.get(1).isPartner(true);
    vendors.get(5).isPartner(true);
    vendors.get(7).isPartner(true);
    final List<Vendor> expectedPartners =
        Arrays.asList(vendors.get(1), vendors.get(5), vendors.get(7));
    final List<Vendor> actualPartners = marketingService.getPartners();
    Assert.assertEquals(expectedPartners, actualPartners);
  }

  /**
   * Set all customers to rejected status. Then set a select few to potential status. Verify that
   * the MarketingService returns these selected potential customers
   *
   * @throws InvalidMarketingStateException if CustomerStore is empty
   */
  @Test
  public void getPotentialCustomers() throws InvalidMarketingStateException {
    final List<Customer> customers = customerService.getCustomers();
    customers.forEach(customer -> customer.setCustomerStatus(CustomerStatus.REJECTED));
    customers.get(1).setCustomerStatus(CustomerStatus.POTENTIAL);
    customers.get(1).setEmail(datafactory.getEmailAddress());
    customers.get(5).setCustomerStatus(CustomerStatus.POTENTIAL);
    customers.get(5).setEmail(datafactory.getEmailAddress());
    customers.get(7).setCustomerStatus(CustomerStatus.POTENTIAL);
    customers.get(7).setEmail(datafactory.getEmailAddress());

    final List<Customer> expectedPotentialCustomers =
        Arrays.asList(customers.get(1), customers.get(5), customers.get(7));
    final List<Customer> actualPotentialCustomers = marketingService.getPotentialCustomers();
    Assert.assertEquals(expectedPotentialCustomers, actualPotentialCustomers);
  }

  /**
   * Set all customers to rejected status. Set a select few to current status. Verify that the
   * MarketingService returns only these select few.
   *
   * @throws InvalidMarketingStateException if CustomerStore is empty
   */
  @Test
  public void getCurrentCustomers() throws InvalidMarketingStateException {
    final List<Customer> customers = customerService.getCustomers();
    customers.forEach(customer -> customer.setCustomerStatus(CustomerStatus.REJECTED));
    customers.get(1).setCustomerStatus(CustomerStatus.CURRENT);
    customers.get(1).setEmail(datafactory.getEmailAddress());
    customers.get(5).setCustomerStatus(CustomerStatus.CURRENT);
    customers.get(5).setEmail(datafactory.getEmailAddress());
    customers.get(7).setCustomerStatus(CustomerStatus.CURRENT);
    customers.get(7).setEmail(datafactory.getEmailAddress());

    final List<Customer> expectedCurrentCustomers =
        Arrays.asList(customers.get(1), customers.get(5), customers.get(7));
    final List<Customer> actualCurrentCustomers = marketingService.getCurrentCustomers();
    Assert.assertEquals(expectedCurrentCustomers, actualCurrentCustomers);
  }

  /**
   * Set all customers to rejected status. Set a select few to contacted status. Verify that the
   * MarketingService returns only these select few.
   *
   * @throws InvalidMarketingStateException if CustomerStore is empty
   */
  @Test
  public void getInProgressCustomers() throws InvalidMarketingStateException {
    final List<Customer> customers = customerService.getCustomers();
    customers.forEach(customer -> customer.setCustomerStatus(CustomerStatus.REJECTED));
    customers.get(1).setCustomerStatus(CustomerStatus.CONTACTED);
    customers.get(1).setEmail(datafactory.getEmailAddress());
    customers.get(5).setCustomerStatus(CustomerStatus.CONTACTED);
    customers.get(5).setEmail(datafactory.getEmailAddress());
    customers.get(7).setCustomerStatus(CustomerStatus.CONTACTED);
    customers.get(7).setEmail(datafactory.getEmailAddress());

    final List<Customer> expectedInProgressCustomers =
        Arrays.asList(customers.get(1), customers.get(5), customers.get(7));
    final List<Customer> actualInProgressCustomers = marketingService.getInProgressCustomers();
    Assert.assertEquals(expectedInProgressCustomers, actualInProgressCustomers);
  }

  /**
   * Set all customers to current status. Set a select few to rejected status. Verify that the
   * MarketingService returns only these select few.
   *
   * @throws InvalidMarketingStateException if CustomerStore is empty
   */
  @Test
  public void getRejectedCustomers() throws InvalidMarketingStateException {
    final List<Customer> customers = customerService.getCustomers();
    customers.forEach(customer -> customer.setCustomerStatus(CustomerStatus.CURRENT));
    customers.get(1).setCustomerStatus(CustomerStatus.REJECTED);
    customers.get(1).setEmail(datafactory.getEmailAddress());
    customers.get(5).setCustomerStatus(CustomerStatus.REJECTED);
    customers.get(5).setEmail(datafactory.getEmailAddress());
    customers.get(7).setCustomerStatus(CustomerStatus.REJECTED);
    customers.get(7).setEmail(datafactory.getEmailAddress());

    final List<Customer> expectedRejectedCustomers =
        Arrays.asList(customers.get(1), customers.get(5), customers.get(7));
    final List<Customer> actualRejectedCustomers = marketingService.getRejectedCustomers();
    Assert.assertEquals(expectedRejectedCustomers, actualRejectedCustomers);
  }

  /**
   * Verify that the MarketingService will throw the correct exception when the CustomerStore is
   * empty
   *
   * @throws InvalidMarketingStateException if the customer store is empty
   */
  @Test(expected = InvalidMarketingStateException.class)
  public void getEmailCustomersEmptyCustomerStore() throws InvalidMarketingStateException {
    customerService.setCustomers(Collections.emptyList());
    marketingService.emailCustomers();
  }

  /**
   * Verify that the MarketingService will throw the correct exception when the VendorStore is empty
   *
   * @throws InvalidMarketingStateException if the vendor store is empty
   */
  @Test(expected = InvalidMarketingStateException.class)
  public void getPartnersEmptyVendorStore() throws InvalidMarketingStateException {
    vendorService.setVendors(Collections.emptyList());
    marketingService.getPartners();
  }
}
