package de.neuefische.backend.service;

import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.enums.BusinessCategory;

import java.util.List;

public interface VendorService {
    String saveVendor(Vendor vendor);
    List<Vendor> getAllVendors();
    List<Vendor> getVendorStartWithName(String name);
    Vendor getVendorWithId(String id);
    String updateVendor(Vendor vendor, String id);
    void deleteVendor(String id);
}
