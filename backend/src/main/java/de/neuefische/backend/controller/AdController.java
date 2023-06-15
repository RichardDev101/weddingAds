package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.model.Address;
import de.neuefische.backend.model.Company;
import de.neuefische.backend.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/ad")
public class AdController {

    @Autowired
    private AdService adService;

    //CREATE
    @PostMapping()
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public Advertisement save(@RequestBody Advertisement advertisement){
        return adService.save(advertisement);
    }

    //READ
    @GetMapping("{id}")
    public Advertisement getAdWithId(@PathVariable String id){
        return adService.getAdWithId(id);
    }
    @GetMapping("/business")
    public List<Advertisement> getAdsByBusiness(@RequestParam("businessCategory")BusinessCategory businessCategory){
        return adService.getAdByBusiness(businessCategory);
    }
    @GetMapping("/payment")
    public List<Advertisement> getAdsByPaymentCategory(@RequestParam("paymentCategory") PaymentCategory paymentCategory){
        return adService.getAdsByPaymentCategory(paymentCategory);
    }
    @GetMapping("/company")
    public List<Advertisement> getAdsByCompany(@RequestParam("companyName") String companyName){
        return adService.getAdsByCompany(companyName);
    }
    @GetMapping("/average-price")
    public List<Advertisement> getAdsByAveragePrice(@RequestParam("averagePrice") float averagePrice){
        return adService.getAdsByAveragePrice(averagePrice);
    }
    @GetMapping("/location")
    public List<Advertisement> getAdsByLocation(@RequestParam("location") Address address){
        return adService.getAdsByLocation(address);
    }
    //UPDATE
    @PutMapping
    public String update(@RequestBody Advertisement advertisement, @RequestParam String id){
        if(!advertisement.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID for advertisement does not match the requirements.");
        } else if (getAdWithId(id)==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is not part of the database.");
        }
        return adService.update(advertisement, id);
    }
    //DELETE
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        adService.delete(id);
    }

}
