package dev.projects.backend.controller;

import dev.projects.backend.collection.Photo;
import dev.projects.backend.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    public ResponseEntity<String> addPhoto(@RequestParam("image") MultipartFile  image) throws IOException {
        try {
            String fileId = photoService.addPhoto(image.getOriginalFilename(), image);
            return ResponseEntity
                    .ok()
                    .body(fileId);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add photo");
        }
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String id){
        Photo photo = photoService.getPhoto(id);

        if (photo == null) {
            return ResponseEntity.notFound().build();
        }

        Resource resource
                = new ByteArrayResource(photo.getImage().getData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+photo.getTitle()+"\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable String id) {
        Photo photo = photoService.getPhoto(id);

        if (photo == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] imageData = photo.getImage().getData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageData.length);

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable String id){
        photoService.deletePhoto(id);
        return ResponseEntity.ok("Image with "+id+" has been deleted.");
    }


}
