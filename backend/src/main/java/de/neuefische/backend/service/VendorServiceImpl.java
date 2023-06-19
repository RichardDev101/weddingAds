package de.neuefische.backend.service;

import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private GenerateUUID uuid;

    @Override
    public String saveVendor(Vendor vendor) {
            vendor.setPersonId(uuid.getUUID());
            vendor.setLoginRole(LoginRole.VENDOR);
            return vendorRepository.save(vendor).getPersonId();
        }
    @Override
    public List<Vendor> getAllVendors() {
       return vendorRepository.findAll();
    }
    @Override
    public Vendor getVendorWithId(String id) {
        return vendorRepository.findVendorByPersonId(id);
    }
    @Override
    public String updateVendor(Vendor vendor, String id) {
        return vendorRepository.save(vendor).getPersonId();
    }
    @Override
    public void deleteVendor(String id) {
        vendorRepository.deleteById(id);
    }
}
