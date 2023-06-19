package de.neuefische.backend.service;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GenerateUUIDService uuid;

    @Override
    public Person saveAdmin(Person person) {
        person.setPersonId(uuid.getUUID());
        person.setLoginRole(LoginRole.ADMIN);
        return personRepository.save(person);
    }
    @Override
    public Person saveEditor(Person person) {
        person.setPersonId(uuid.getUUID());
        person.setLoginRole(LoginRole.EDITOR);
        return personRepository.save(person);
    }

    @Override
    public Person saveUser(Person person) {
        person.setPersonId(uuid.getUUID());
        person.setLoginRole(LoginRole.USER);
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> getPersonsByRole(LoginRole role) {
        return personRepository.findByLoginRoleIs(role);
    }

    @Override
    public Person getPersonById(String id) {
        return personRepository.findById(id).orElseThrow(()->new NoSuchElementException("Person-ID: " +id+ " is not part of the database."));
    }

    @Override
    public Person update(Person person, String id) {
        personRepository.findById(id).orElseThrow(()->new NoSuchElementException("Person-ID: " +id+ " is not part of the database."));
        return personRepository.save(person);
    }
    @Override
    public void delete(String id) {
        personRepository.findById(id).orElseThrow(()->new NoSuchElementException("Person-ID: " +id+ " is not part of the database."));
        personRepository.deleteById(id);
    }





}
