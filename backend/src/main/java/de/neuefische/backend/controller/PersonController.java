package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person){
        return personService.save(person);
    }
    @GetMapping
    public List<Person>getPersonStartWith(@RequestParam("name") String name){
        return personService.getPersonStartWith(name);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
         personService.delete(id);
    }
}
