package dev.projects.backend.service;

import dev.projects.backend.collection.Advertisement;
import dev.projects.backend.dto.AdvertisementDTO;
import dev.projects.backend.repository.AdRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}