package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.collection.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.*;
import java.util.List;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    public Vendor findVendorByPersonId(String id);
    public List<Vendor> findByFirstNameStartsWithOrLastNameStartsWith (String name);

}
