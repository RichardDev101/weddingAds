package de.neuefische.backend.service;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.AdvertisementStatus;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.model.Address;
import de.neuefische.backend.model.Company;

import java.util.List;

public interface AdService {
    Advertisement save(Advertisement advertisement);
    Advertisement getAdWithId(String id);
    List<Advertisement> getAdByBusiness(BusinessCategory businessCategory);
    List<Advertisement> getAdsByPaymentCategory(PaymentCategory paymentCategory);
    List<Advertisement> getAdsByCompany(String companyName);
    List<Advertisement> getAdsByAveragePrice(float averagePrice);
    List<Advertisement> getAdsByLocation(Address address);
    String update(Advertisement advertisement, String id);
    void delete(String id);
}
