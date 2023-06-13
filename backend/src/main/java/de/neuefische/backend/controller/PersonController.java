package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.service.PersonService;
import de.neuefische.backend.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person){
        return personService.save(person);
    }
}
