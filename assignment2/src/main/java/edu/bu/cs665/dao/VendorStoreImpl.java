package edu.bu.cs665.dao;

import edu.bu.cs665.dto.Vendor;
import java.util.ArrayList;
import java.util.List;

public class VendorStoreImpl implements VendorStore {

  private List<Vendor> m_vendors = new ArrayList<>();

  private VendorStoreImpl() {}

  private static class VendorStoreImplHolder {
    private static final VendorStore instance = new VendorStoreImpl();
  }

  public static VendorStore getVendorStore() {
    return VendorStoreImplHolder.instance;
  }

  @Override
  public List<Vendor> getVendors() {
    return m_vendors;
  }

  @Override
  public void setVendors(final List<Vendor> vendors) {
    m_vendors = vendors;
  }
}
