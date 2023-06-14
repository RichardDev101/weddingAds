package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    //CREATE
    @PostMapping
    public String save(@RequestBody Person person){
        return personService.save(person);
    }
    @GetMapping
    public List<Person>getPersonStartWith(@RequestParam("name") String name){
        return personService.getPersonStartWith(name);
    }
    @GetMapping("{id}")
    public Person getPersonWith(@RequestParam String id){
        return personService.getPersonWith(id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
         personService.delete(id);
    }
    @PutMapping
    public String update(@RequestBody Person person, @RequestParam String id){
        if(!person.getPersonId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID for person does not match the requirements.");
        } else if (getPersonWith(id)==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is not part of the database");
        }
        return personService.update(person, id);
    }
}
