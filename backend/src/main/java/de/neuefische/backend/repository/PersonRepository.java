package de.neuefische.backend.repository;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.LoginRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    public List<Person> findByLoginRoleIs(LoginRole role);
    public Person findByPersonId(String id);


}
