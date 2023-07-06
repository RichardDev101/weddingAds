package dev.projects.backend.service;

import dev.projects.backend.collection.Advertisement;
import dev.projects.backend.dto.AdvertisementDTO;
import dev.projects.backend.repository.AdRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AdServiceTest {

    AdRepository adRepository = mock(AdRepository.class);
    GenerateUUIDService generateUUIDService = mock(GenerateUUIDService.class);
    AdService adService = new AdService(adRepository,generateUUIDService);

    @Test
    void testSaveAdvertisement_ShouldSaveAdvertisementAndReturnExpected() {
        // ARRANGE
        AdvertisementDTO adDTO = new AdvertisementDTO();
        Advertisement ad = new Advertisement();
        Advertisement expected = new Advertisement();
        // ACT
        when(adRepository.save(ad)).thenReturn(expected);
        Advertisement actual = adService.save(adDTO);
        // ASSERT
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
        List<Advertisement> actual = adService.getAllAds();
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
        Advertisement actualAd = adService.getAdWithId(id);
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
        assertThrows(NoSuchElementException.class, () -> adService.getAdWithId(id));
        verify(adRepository).findById(id);
    }


    @Test
    void testUpdateAd_ShouldUpdateAdvertisementAndReturnId() {
        // ARRANGE
        String id = "21245";
        String originalTitle = "Das ist der original Titel";
        Advertisement originalAdvertisement = new Advertisement();
        originalAdvertisement.setId(id);
        originalAdvertisement.setTitle(originalTitle);

        String updatedTitle = "Das ist der neue Titel";
        AdvertisementDTO updatedAdvertisementDTO = new AdvertisementDTO();
        updatedAdvertisementDTO.setTitle(updatedTitle);

        Advertisement updatedAdvertisement = new Advertisement();
        updatedAdvertisement.setId(id);
        updatedAdvertisement.setTitle(updatedTitle);

        when(adRepository.findById(id)).thenReturn(Optional.of(originalAdvertisement));
        when(adRepository.save(any(Advertisement.class))).thenReturn(updatedAdvertisement);
        // ACT
        String result = adService.updateAd(updatedAdvertisementDTO, id);

        // ASSERT
        verify(adRepository).findById(id);
        verify(adRepository).save(any(Advertisement.class));
        assertEquals(id, result);
        assertEquals(updatedTitle, updatedAdvertisement.getTitle());
    }

}