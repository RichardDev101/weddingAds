package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Photo;
import de.neuefische.backend.service.PhotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public String addPhoto(@RequestParam("image") MultipartFile  image) throws IOException {
        String id = photoService.addPhoto(image.getOriginalFilename(),image);
        return id;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String id){
        Photo photo = photoService.getPhoto(id);
        Resource resource
                = new ByteArrayResource(photo.getPhoto().getData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+photo.getTitle()+"\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable String id){
        try {
            photoService.deletePhoto(id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, image has not been deleted");
        }
        return ResponseEntity.ok("Image with "+id+" has been deleted.");
    }


}
