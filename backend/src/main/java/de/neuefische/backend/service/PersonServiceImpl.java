package de.neuefische.backend.service;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public String save(Person person) {
        return personRepository.save(person).getPersonId();
    }

    @Override
    public List<Person> getPersonStartWith(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }
    @Override
    public Person getPersonWith(String id) {
        return personRepository.findByPersonId(id);
    }

    @Override
    public void delete(String id) {
        personRepository.deleteById(id);
    }
    @Override
    public String update(Person person, String id) {
        return personRepository.save(person).getPersonId();
    }




}
