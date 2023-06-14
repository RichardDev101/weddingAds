package de.neuefische.backend.controller;


import de.neuefische.backend.collection.Person;
import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.service.PersonService;
import de.neuefische.backend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorController {


    @Autowired
    private VendorService vendorService;

    //CREATE
    @PostMapping()
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveVendor(@RequestBody Vendor vendor){
        return vendorService.saveVendor(vendor);
    }

}
