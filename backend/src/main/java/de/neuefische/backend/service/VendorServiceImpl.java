package de.neuefische.backend.service;

import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private GenerateUUIDService uuid;

    @Override
    public Vendor saveVendor(Vendor vendor) {
            vendor.setPersonId(uuid.getUUID());
            vendor.setLoginRole(LoginRole.VENDOR);
            return vendorRepository.save(vendor);
        }
    @Override
    public List<Vendor> getAllVendors() {
       return vendorRepository.findAll();
    }
    @Override
    public Vendor getVendorById(String id) {
        vendorRepository.findById(id).orElseThrow(()->new NoSuchElementException("Vendor-ID: " +id+ " is not part of the database."));
        return vendorRepository.findVendorByPersonId(id);
    }
    @Override
    public Vendor updateVendor(Vendor vendor, String id) {
        vendorRepository.findById(id).orElseThrow(()->new NoSuchElementException("Vendor-ID: " +id+ " is not part of the database."));
        return vendorRepository.save(vendor);
    }
    @Override
    public void deleteVendor(String id) {
        vendorRepository.findById(id).orElseThrow(()->new NoSuchElementException("Vendor-ID: " +id+ " is not part of the database."));
        vendorRepository.deleteById(id);
    }
}
