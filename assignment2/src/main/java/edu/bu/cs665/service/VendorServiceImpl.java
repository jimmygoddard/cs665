package edu.bu.cs665.service;

import edu.bu.cs665.dao.VendorStore;
import edu.bu.cs665.dto.Vendor;
import java.util.List;

public class VendorServiceImpl implements VendorService {

  private final VendorStore m_vendorStore;

  public VendorServiceImpl(final VendorStore vendorStore) {
    m_vendorStore = vendorStore;
  }

  @Override
  public List<Vendor> getVendors() {
    return m_vendorStore.getVendors();
  }

  @Override
  public void setVendors(final List<Vendor> vendors) {
    m_vendorStore.setVendors(vendors);
  }
}
