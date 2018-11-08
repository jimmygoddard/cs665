package edu.bu.cs665.dao;

import edu.bu.cs665.dto.Vendor;
import java.util.List;

public interface VendorStore {

  List<Vendor> getVendors();

  void setVendors(List<Vendor> vendors);
}
