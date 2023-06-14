package de.neuefische.backend.service;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.LoginRole;
import java.util.List;

public interface PersonService {
    String saveUser(Person person);
    String saveAdmin(Person person);
    String saveEditor(Person person);
    Person getPersonWithId(String id);
    List<Person> getPersonsByRole(LoginRole role);
    List<Person> getPersonsStartWithName(String name);
    String update(Person person, String id);
    void delete(String id);

}
