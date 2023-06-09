package dev.projects.backend.controller;

import dev.projects.backend.collection.Photo;
import dev.projects.backend.service.PhotoService;
import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PhotoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PhotoService photoService;

    @Test
    @DirtiesContext
    void testAddPhoto_Success() throws Exception {
        MockMultipartFile image = new MockMultipartFile("image", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "Test data".getBytes());

        String fileId = "fileId123";
        when(photoService.addPhoto(image.getOriginalFilename(), image)).thenReturn(fileId);

        mockMvc.perform(multipart("/api/photo")
                        .file(image))
                .andExpect(status().isOk())
                .andExpect(content().string(fileId));

        verify(photoService).addPhoto(image.getOriginalFilename(), image);
    }
    @Test
    @DirtiesContext
    void testAddPhoto_Failure() throws Exception {
        MockMultipartFile image = new MockMultipartFile("image", "test.jpg", MediaType.IMAGE_JPEG_VALUE, "Test data".getBytes());

        doThrow(new IOException()).when(photoService).addPhoto(image.getOriginalFilename(), image);

        mockMvc.perform(multipart("/api/photo")
                        .file(image))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Failed to add photo"));

        verify(photoService).addPhoto(image.getOriginalFilename(), image);
    }

    @Test
    void testDownloadPhoto_NotFound() throws Exception {
        when(photoService.getPhoto("photoId123")).thenReturn(null);

        mockMvc.perform(get("/api/photo/download/{id}", "photoId123"))
                .andExpect(status().isNotFound());

        verify(photoService).getPhoto("photoId123");
    }

    @Test
    @DirtiesContext
    void testDownloadPhoto() throws Exception {
        Photo photo = new Photo();
        photo.setImage(new Binary("Test data".getBytes()));
        photo.setTitle("test.jpg");

        when(photoService.getPhoto("photoId123")).thenReturn(photo);

        mockMvc.perform(get("/api/photo/download/{id}", "photoId123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM))
                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"test.jpg\""))
                .andExpect(content().bytes("Test data".getBytes()));

        verify(photoService).getPhoto("photoId123");
    }
    @Test
    void testGetPhoto() throws Exception {
        Photo photo = new Photo();
        photo.setImage(new Binary("Test data".getBytes()));
        photo.setTitle("test.jpg");

        when(photoService.getPhoto("photoId123")).thenReturn(photo);

        mockMvc.perform(get("/api/photo/show/{id}", "photoId123"))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE))
                .andExpect(content().bytes("Test data".getBytes()));

        verify(photoService).getPhoto("photoId123");
    }
    @Test
    @DirtiesContext
    void testDeletePhoto() throws Exception {
        mockMvc.perform(delete("/api/photo/{id}", "photoId123"))
                .andExpect(status().isOk())
                .andExpect(content().string("Image with photoId123 has been deleted."));

        verify(photoService).deletePhoto("photoId123");
    }

}