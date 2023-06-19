package de.neuefische.backend.service;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.LoginRole;
import java.util.List;

public interface PersonService {
    String saveUser(Person person);
    String saveAdmin(Person person);
    String saveEditor(Person person);
    List<Person> getAllPersons();
    Person getPersonById(String id);
    List<Person> getPersonsByRole(LoginRole role);
    String update(Person person, String id);
    void delete(String id);

}
