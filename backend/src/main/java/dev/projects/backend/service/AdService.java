package dev.projects.backend.service;

import dev.projects.backend.collection.Advertisement;
import dev.projects.backend.dto.AdvertisementDTO;
import dev.projects.backend.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdService {

    private final AdRepository adRepository;
    private final GenerateUUIDService uuid;

    public Advertisement save(AdvertisementDTO ad) {
        Advertisement newAd =Advertisement.builder()
                .id(uuid.getUUID())
                .advertisementStatus(ad.getAdvertisementStatus())
                .paymentCategory(ad.getPaymentCategory())
                .company(ad.getCompany())
                .businessCategories(ad.getBusinessCategories())
                .photosID(ad.getPhotosID())
                .title(ad.getTitle())
                .aboutYourself(ad.getAboutYourself())
                .detailInformationForService(ad.getDetailInformationForService())
                .averagePrice(ad.getAveragePrice())
                .priceCategories(ad.getPriceCategories())
                .customerContacts(ad.getCustomerContacts())
                .locations(ad.getLocations())
                .personsID(ad.getPersonsID())
                .build();
        return adRepository.save(newAd);
    }
    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }

    public Advertisement getAdWithId(String id) {
        Optional<Advertisement> optionalAdvertisement = adRepository.findById(id);
        if (optionalAdvertisement.isPresent()) {
            return optionalAdvertisement.get();
        } else {
            throw new NoSuchElementException();
        }
    }
    public String updateAd(AdvertisementDTO ad, String id) {
        Optional<Advertisement> optionalAdvertisement = adRepository.findById(id);
        if(optionalAdvertisement.isEmpty()){
            throw new NoSuchElementException();
        }else {
            Advertisement updatedAd = Advertisement.builder()
                    .id(id)
                    .advertisementStatus(ad.getAdvertisementStatus())
                    .paymentCategory(ad.getPaymentCategory())
                    .company(ad.getCompany())
                    .businessCategories(ad.getBusinessCategories())
                    .photosID(ad.getPhotosID())
                    .title(ad.getTitle())
                    .aboutYourself(ad.getAboutYourself())
                    .detailInformationForService(ad.getDetailInformationForService())
                    .averagePrice(ad.getAveragePrice())
                    .priceCategories(ad.getPriceCategories())
                    .customerContacts(ad.getCustomerContacts())
                    .locations(ad.getLocations())
                    .personsID(ad.getPersonsID())
                    .build();
            return adRepository.save(updatedAd).getId();
        }
    }

}
