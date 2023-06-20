package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends MongoRepository<Advertisement, String> {
    List<Advertisement> findAdvertisementsByBusinessCategories(BusinessCategory businessCategory);
    List<Advertisement> findAdvertisementsByPaymentCategory(PaymentCategory paymentCategory);
    List<Advertisement> findAdvertisementsByAveragePriceIsLessThanEqual(float averagePrice);
}
