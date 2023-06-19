package de.neuefische.backend.service;

import de.neuefische.backend.collection.Photo;
import de.neuefische.backend.repository.PhotoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private GenerateUUIDService uuid;

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
        Photo photo = new Photo();
        photo.setId(uuid.getUUID());
        photo.setTitle(originalFilename);
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        return photoRepository.save(photo).getId();
    }
    @Override
    public Photo getPhoto(String id) {
        Optional<Photo> optionalPhoto = photoRepository.findById(id);
        if (optionalPhoto.isPresent()) {
            return optionalPhoto.get();
        } else {
            throw new NoSuchElementException("Photo with ID: " + id + " not found.");
        }
    }
    @Override
    public void deletePhoto(String id) {
        photoRepository.deleteById(id);
    }
}
