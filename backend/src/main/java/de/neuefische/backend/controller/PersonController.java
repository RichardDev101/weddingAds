package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    private Person person;

    //CREATE
    @PostMapping("/master-admin")
    public ResponseEntity<String> checkAndCreateMasterAdmin(){
        List<Person> personList = getPersonsByRole(LoginRole.ADMIN);
        if(personList!=null) {
            for (int i=0; i<personList.size(); i++){
                if(personList.get(i).getUserName()=="${ENV_UN_Admin}"){
                    return ResponseEntity.ok("MasterAdmin already exists.");
                }
            }
        }
        Person person = new Person();
        person.setUserName("${ENV_UN_Admin}");
        person.setPassWord("${ENV_PW_Admin}");
        saveAdmin(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("MasterAdmin has been successfully created.");
    }
    @PostMapping("/admin")
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveAdmin(@RequestBody Person person){
        return personService.saveAdmin(person);
    }
    @PostMapping("/editor")
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveEditor(@RequestBody Person person){
        return personService.saveEditor(person);
    }
    @PostMapping("/user")
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveUser(@RequestBody Person person){
        return personService.saveUser(person);
    }
    //READ
    @GetMapping
    public List<Person> getPersonsByRole(@RequestParam("role") LoginRole role){
        return personService.getPersonsByRole(role);
    }
    @GetMapping
    public List<Person> getPersonsStartWithName(@RequestParam("name") String name){
        return personService.getPersonsStartWithName(name);
    }
    @GetMapping("{id}")
    public Person getPersonWithId(@PathVariable String id){
        return personService.getPersonWithId(id);
    }
    //UPDATE
    @PutMapping
    public String update(@RequestBody Person person, @RequestParam String id){
        if(!person.getPersonId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID for person does not match the requirements.");
        } else if (getPersonWithId(id)==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is not part of the database.");
        }
        return personService.update(person, id);
    }
    //DELETE
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        personService.delete(id);
    }
}
