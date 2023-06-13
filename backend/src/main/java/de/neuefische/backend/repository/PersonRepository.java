package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    public List<Person> findByFirstNameStartsWith(String Name);
}
