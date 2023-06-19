package de.neuefische.backend.service;

import de.neuefische.backend.collection.Vendor;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.repository.VendorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class VendorServiceImplTest {

    private VendorRepository vendorRepository = mock(VendorRepository.class);
    private GenerateUUIDService generateUUIDService = mock(GenerateUUIDService.class);
    private VendorServiceImpl vendorServiceImpl= new VendorServiceImpl(vendorRepository, generateUUIDService);

    @Test
    void testSaveVendor_ShouldSaveVendorAndReturnSavedVendor() {
        // ARRANGE
        Vendor vendor = new Vendor();
        vendor.setLoginRole(LoginRole.VENDOR);

        String uuid = "123";
        when(generateUUIDService.getUUID()).thenReturn(uuid);
        when(vendorRepository.save(vendor)).thenReturn(vendor);

        // ACT
        Vendor result = vendorServiceImpl.saveVendor(vendor);

        // ASSERT
        verify(generateUUIDService).getUUID();
        verify(vendorRepository).save(vendor);

        assertEquals(uuid, vendor.getPersonId());
        assertEquals(LoginRole.VENDOR, vendor.getLoginRole());
        assertEquals(vendor, result);
    }

    @Test
    void testGetAllVendors_ShouldReturnAllVendors() {
        // ARRANGE
        List<Vendor> vendorList = new ArrayList<>();
        vendorList.add(new Vendor());
        vendorList.add(new Vendor());

        when(vendorRepository.findAll()).thenReturn(vendorList);

        // ACT
        List<Vendor> result = vendorServiceImpl.getAllVendors();

        // ASSERT
        verify(vendorRepository).findAll();
        assertEquals(vendorList, result);
    }

    @Test
    void testGetVendorById_WithExistingId_ShouldReturnVendor() {
        // ARRANGE
        String vendorId = "123";
        Vendor vendor = new Vendor();
        when(vendorRepository.findById(vendorId)).thenReturn(java.util.Optional.of(vendor));
        when(vendorRepository.findVendorByPersonId(vendorId)).thenReturn(vendor);

        // ACT
        Vendor result = vendorServiceImpl.getVendorById(vendorId);

        // ASSERT
        verify(vendorRepository).findById(vendorId);
        verify(vendorRepository).findVendorByPersonId(vendorId);
        assertEquals(vendor, result);
    }

    @Test
    void testGetVendorById_WithNonExistingId_ShouldThrowException() {
        // ARRANGE
        String vendorId = "123";
        when(vendorRepository.findById(vendorId)).thenReturn(java.util.Optional.empty());

        // ACT & ASSERT
        assertThrows(NoSuchElementException.class, () -> vendorServiceImpl.getVendorById(vendorId));
        verify(vendorRepository).findById(vendorId);
        verify(vendorRepository, never()).findVendorByPersonId(vendorId);
    }

    @Test
    void testUpdateVendor_WithExistingId_ShouldUpdateAndReturnVendor() {
        // ARRANGE
        String vendorId = "123";
        Vendor vendor = new Vendor();
        when(vendorRepository.findById(vendorId)).thenReturn(java.util.Optional.of(vendor));
        when(vendorRepository.save(vendor)).thenReturn(vendor);

        // ACT
        Vendor result = vendorServiceImpl.updateVendor(vendor, vendorId);

        // ASSERT
        verify(vendorRepository).findById(vendorId);
        verify(vendorRepository).save(vendor);
        assertEquals(vendor, result);
    }
    @Test
    void testDeleteVendor_WithNonExistingId_ShouldThrowException() {
        // ARRANGE
        String vendorId = "123";
        when(vendorRepository.findById(vendorId)).thenReturn(java.util.Optional.empty());

        // ACT & ASSERT
        assertThrows(NoSuchElementException.class, () -> vendorServiceImpl.deleteVendor(vendorId));
        verify(vendorRepository).findById(vendorId);
        verify(vendorRepository, never()).deleteById(vendorId);
    }
}