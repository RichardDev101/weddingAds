package de.neuefische.backend.service;

import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.repository.VendorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
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
        Optional<Vendor> optionalVendor = vendorRepository.findById(id);
        if(optionalVendor.isPresent()){
            return optionalVendor.get();
        }else{
            throw new NoSuchElementException("Vendor-ID: " + id + " is not part of the database.");
        }
    }

    @Override
    public Vendor updateVendor(Vendor vendor, String id) {
        Optional<Vendor> optionalVendor = vendorRepository.findById(id);
        if(optionalVendor.isEmpty()){
            throw new NoSuchElementException("Vendor-ID: " + id + " is not part of the database.");
        }else{
            return vendorRepository.save(vendor);
        }
    }

    @Override
    public void deleteVendor(String id) {
        Optional<Vendor> optionalVendor = vendorRepository.findById(id);
        if(optionalVendor.isEmpty()){
            throw new NoSuchElementException("Vendor-ID: " + id + " is not part of the database.");
        }else{
            vendorRepository.deleteById(id);
        }
    }
}
