package de.neuefische.backend.service;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.model.Address;
import de.neuefische.backend.model.Company;
import de.neuefische.backend.repository.AdRepository;
import de.neuefische.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService{

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private GenerateUUID uuid;

    @Override
    public Advertisement save(Advertisement advertisement) {
        advertisement.setId(uuid.getUUID());
        return adRepository.save(advertisement);
    }
    @Override
    public Advertisement getAdWithId(String id) {
        return adRepository.findAdvertisementById(id);
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
    public List<Advertisement> getAdsByCompany(String companyName) {
        return adRepository.findAdvertisementsByCompanyContains(companyName);
    }
    @Override
    public List<Advertisement> getAdsByAveragePrice(float averagePrice) {
        return adRepository.findAdvertisementsByAveragePrice(averagePrice);
    }
    @Override
    public List<Advertisement> getAdsByLocation(Address address) {
        return adRepository.findAdvertisementsByLocationsContains(address);
    }
    @Override
    public String update(Advertisement advertisement, String id) {
        return adRepository.save(advertisement).getId();
    }
    @Override
    public void delete(String id) {
        adRepository.deleteById(id);
    }
}
