package de.neuefische.backend.service;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.repository.AdRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class AdServiceImpl implements AdService{

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private GenerateUUIDService uuid;

    @Override
    public Advertisement save(Advertisement advertisement) {
        advertisement.setId(uuid.getUUID());
        return adRepository.save(advertisement);
    }

    @Override
    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }
    @Override
    public Advertisement getAdWithId(String id) {
        return adRepository.findById(id).orElseThrow(()->new NoSuchElementException("ID: " +id+ " is not part of the database."));
    }
    @Override
    public List<Advertisement> getAdByBusiness(BusinessCategory businessCategory) {
        return adRepository.findAdvertisementsByBusinessCategories(businessCategory);
    }
    @Override
    public List<Advertisement> getAdsByPaymentCategory(PaymentCategory paymentCategory) {
        return adRepository.findAdvertisementsByPaymentCategory(paymentCategory);
    }
    @Override
    public List<Advertisement> getAdsByAveragePriceIsLessOrEqual(float averagePrice) {
        return adRepository.findAdvertisementsByAveragePriceIsLessThanEqual(averagePrice);
    }
    @Override
    public String updateAd(Advertisement advertisement, String id) {
        adRepository.findById(id).orElseThrow(()->new NoSuchElementException("Ad-ID: " +id+ " is not part of the database."));
        return adRepository.save(advertisement).getId();
    }
    @Override
    public void delete(String id) {
        adRepository.findById(id).orElseThrow(()->new NoSuchElementException("Ad-ID: " +id+ " is not part of the database."));
        adRepository.deleteById(id);
    }

}
