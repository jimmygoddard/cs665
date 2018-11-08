package edu.bu.cs665.service;

import edu.bu.cs665.dto.Vendor;
import java.util.List;

public interface VendorService {

  List<Vendor> getVendors();

  void setVendors(List<Vendor> vendors);
}
