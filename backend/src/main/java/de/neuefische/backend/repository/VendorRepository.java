package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.collection.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {
    public Vendor findVendorByPersonId(String id);

}
