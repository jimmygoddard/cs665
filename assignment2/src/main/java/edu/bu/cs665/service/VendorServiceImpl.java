package edu.bu.cs665.service;

import edu.bu.cs665.dao.VendorStore;
import edu.bu.cs665.dto.Vendor;
import java.util.List;

public class VendorServiceImpl implements VendorService {

  private final VendorStore vendorStore;

  public VendorServiceImpl(final VendorStore vendorStore) {
    this.vendorStore = vendorStore;
  }

  @Override
  public List<Vendor> getVendors() {
    return vendorStore.getVendors();
  }

  @Override
  public void setVendors(final List<Vendor> vendors) {
    vendorStore.setVendors(vendors);
  }

  @Override
  public void addVendors(final List<Vendor> vendors) {
    vendorStore.getVendors().addAll(vendors);
  }
}
