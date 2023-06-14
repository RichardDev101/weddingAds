package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {


    @Autowired
    private VendorService vendorService;

    //CREATE
    @PostMapping()
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveVendor(@RequestBody Vendor vendor){
        return vendorService.saveVendor(vendor);
    }
    //READ
    @GetMapping
    public List<Vendor> getAllVendors(){
        return vendorService.getAllVendors();
    }
    @GetMapping
    public List<Vendor> getVendorStartWithName(@RequestParam("name") String name){
        return vendorService.getVendorStartWithName(name);
    }
    @GetMapping("{id}")
    public Vendor getVendorWithId(@PathVariable String id){
        return vendorService.getVendorWithId(id);
    }
    //UPDATE
    @PutMapping
    public String update(@RequestBody Vendor vendor, @RequestParam String id){
        if(!vendor.getPersonId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID for person does not match the requirements.");
        } else if (getVendorWithId(id)==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is not part of the database.");
        }
        return vendorService.updateVendor(vendor, id);
    }
    //DELETE
    @DeleteMapping("{id}")
    public void deleteVendor(@PathVariable String id){
        vendorService.deleteVendor(id);
    }
}
