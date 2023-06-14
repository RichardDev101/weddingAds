package de.neuefische.backend.service;

import de.neuefische.backend.collection.Photo;
import de.neuefische.backend.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private GenerateUUID uuid;

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
        return photoRepository.findById(id).get();
    }
    @Override
    public void deletePhoto(String id) {
        photoRepository.deleteById(id);
    }
}
