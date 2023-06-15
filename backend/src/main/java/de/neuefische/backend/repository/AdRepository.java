package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.model.Address;
import de.neuefische.backend.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends MongoRepository<Advertisement, String> {

    public Advertisement findAdvertisementById(String id);
    public List<Advertisement> findAdvertisementsByBusinessCategories(BusinessCategory businessCategory);
    public List<Advertisement> findAdvertisementsByPaymentCategory(PaymentCategory paymentCategory);
    public List<Advertisement> findAdvertisementsByCompanyContains(String companyName);
    public List<Advertisement> findAdvertisementsByAveragePrice(float averagePrice);
    public List<Advertisement> findAdvertisementsByLocationsContains(Address address);
}
