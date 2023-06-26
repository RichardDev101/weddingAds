package dev.projects.backend.service;

import dev.projects.backend.collection.Advertisement;
import dev.projects.backend.dto.AdvertisementDTO;
import dev.projects.backend.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .contacts(ad.getContacts())
                .locations(ad.getLocations())
                .personsID(ad.getPersonsID())
                .build();
        return adRepository.save(newAd);
    }
    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }

}
