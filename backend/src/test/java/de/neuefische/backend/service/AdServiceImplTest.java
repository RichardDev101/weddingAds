package de.neuefische.backend.service;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.PaymentCategory;
import de.neuefische.backend.repository.AdRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AdServiceImplTest {

    AdRepository adRepository = mock(AdRepository.class);
    GenerateUUIDService generateUUIDService = mock(GenerateUUIDService.class);
    AdServiceImpl adServiceImpl = new AdServiceImpl(adRepository,generateUUIDService);

    @Test
    void testSaveAdvertisement_ShouldSaveAdvertisementAndReturnExpected() {
        // ARRANGE
        Advertisement ad = new Advertisement();
        Advertisement expected = new Advertisement();

        //WHEN
        when(adRepository.save(ad)).thenReturn(expected);
        Advertisement actual = adServiceImpl.save(ad);

        //THEN
        verify(adRepository).save(expected);
        verify(generateUUIDService).getUUID();
        assertEquals(expected, actual);
    }

    @Test
    void testGetAllAds_ShouldReturnListOfAdvertisements() {
        // ARRANGE
        List<Advertisement> expected = List.of(new Advertisement(), new Advertisement());
        // ACT
        when(adRepository.findAll()).thenReturn(expected);
        List<Advertisement> actual =adServiceImpl.getAllAds();
        // ASSERT
        verify(adRepository).findAll();
        assertEquals(actual, expected);
    }

    @Test
    void testGetAdWithId_ExistingId_ReturnsAdvertisement() {
        // ARRANGE
        String id = "4645";
        Advertisement expectedAd = new Advertisement();
        expectedAd.setId(id);
        when(adRepository.findById(id)).thenReturn(Optional.of(expectedAd));
        // ACT
        Advertisement actualAd = adServiceImpl.getAdWithId(id);
        // ASSERT
        assertEquals(expectedAd, actualAd);
        verify(adRepository).findById(id);
    }
    @Test
    void testGetAdWithId_NonExistingId_ThrowsNoSuchElementException() {
        // Arrange
        String id = "65487";
        when(adRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> adServiceImpl.getAdWithId(id));
        verify(adRepository).findById(id);
    }

    @Test
    void testGetAdByBusiness_ShouldReturnListOfAdvertisementsForGivenBusinessCategory() {
        // ARRANGE
        BusinessCategory businessCategory = BusinessCategory.BAKERY;
        List<Advertisement> expected = List.of(new Advertisement(), new Advertisement());

        // ACT
        when(adRepository.findAdvertisementsByBusinessCategories(businessCategory)).thenReturn(expected);
        List<Advertisement> actual = adServiceImpl.getAdByBusiness(businessCategory);

        // ASSERT
        verify(adRepository).findAdvertisementsByBusinessCategories(businessCategory);
        assertEquals(expected, actual);
    }

    @Test
    void testGetAdsByPaymentCategory_ShouldReturnListOfAdvertisementsForGivenPaymentCategory() {
        // ARRANGE
        PaymentCategory paymentCategory = PaymentCategory.PREMIUM;
        List<Advertisement> expected = List.of(new Advertisement(), new Advertisement());

        // ACT
        when(adRepository.findAdvertisementsByPaymentCategory(paymentCategory)).thenReturn(expected);
        List<Advertisement> actual = adServiceImpl.getAdsByPaymentCategory(paymentCategory);

        // ASSERT
        verify(adRepository).findAdvertisementsByPaymentCategory(paymentCategory);
        assertEquals(expected, actual);
    }

    @Test
    void testGetAdsByAveragePriceIsLessOrEqual_ShouldReturnListOfAdvertisementsWithAveragePriceLessOrEqual() {
        // ARRANGE
        float averagePrice = 100.00f;
        List<Advertisement> expected = List.of(new Advertisement(), new Advertisement());

        // ACT
        when(adRepository.findAdvertisementsByAveragePriceIsLessThanEqual(averagePrice)).thenReturn(expected);
        List<Advertisement> actual = adServiceImpl.getAdsByAveragePriceIsLessOrEqual(averagePrice);

        // ASSERT
        verify(adRepository).findAdvertisementsByAveragePriceIsLessThanEqual(averagePrice);
        assertEquals(expected, actual);
    }

    @Test
    void testUpdateAd_ShouldUpdateAdvertisementAndReturnId() {
        // ARRANGE
        String id = "3423352";
        Advertisement originalAdvertisement = new Advertisement();
        originalAdvertisement.setId(id);

        Advertisement updatedAdvertisement = new Advertisement();
        updatedAdvertisement.setId(id);
        updatedAdvertisement.setTitle("Updated Title");

        // ACT
        when(adRepository.findById(id)).thenReturn(Optional.of(originalAdvertisement));
        when(adRepository.save(updatedAdvertisement)).thenReturn(updatedAdvertisement);
        String result = adServiceImpl.updateAd(updatedAdvertisement, id);

        // ASSERT
        verify(adRepository).findById(id);
        verify(adRepository).save(updatedAdvertisement);
        assertEquals(id, result);
    }

    @Test
    void testDelete_ShouldDeleteAdvertisement() {
        // ARRANGE
        String id = "123";

        // ACT
        when(adRepository.findById(id)).thenReturn(Optional.of(new Advertisement()));
        adServiceImpl.delete(id);

        // ASSERT
        verify(adRepository).findById(id);
        verify(adRepository).deleteById(id);
    }

}