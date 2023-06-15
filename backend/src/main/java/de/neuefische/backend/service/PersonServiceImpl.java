package de.neuefische.backend.service;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GenerateUUID uuid;

    @Override
    public String saveAdmin(Person person) {
        person.setPersonId(uuid.getUUID());
        person.setLoginRole(LoginRole.ADMIN);
        return personRepository.save(person).getPersonId();
    }
    @Override
    public String saveEditor(Person person) {
        person.setPersonId(uuid.getUUID());
        person.setLoginRole(LoginRole.EDITOR);
        return personRepository.save(person).getPersonId();
    }

    @Override
    public String saveUser(Person person) {
        person.setPersonId(uuid.getUUID());
        person.setLoginRole(LoginRole.USER);
        return personRepository.save(person).getPersonId();
    }

    @Override
    public List<Person> getPersonsByRole(LoginRole role) {
        return personRepository.findByLoginRoleIs(role);
    }
    @Override
    public List<Person> getPersonsStartWithName(String name) {
        return personRepository.findByFirstNameStartsWithOrLastNameStartsWith(name);
    }
    @Override
    public Person getPersonWithId(String id) {
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
