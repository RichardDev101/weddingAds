package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.collection.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor, String> {
}
