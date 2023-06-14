package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends MongoRepository<Advertisement, String> {
}
