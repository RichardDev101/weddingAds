package de.neuefische.backend.service;

import de.neuefische.backend.collection.Person;

import java.util.List;

public interface PersonService {
    String save(Person person);

    List<Person> getPersonStartWith(String name);

    void delete(String id);
}
