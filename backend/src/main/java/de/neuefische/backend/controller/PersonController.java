package de.neuefische.backend.controller;

import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.collection.Person;
import de.neuefische.backend.dto.PersonDTO;
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

    //CREATE
    @PostMapping("/master-admin")
    public ResponseEntity<String> checkAndCreateMasterAdmin(){
        List<Person> personList = getPersonsByRole(LoginRole.ADMIN);
        if(personList.size()!=0) {
            for (int i=0; i<personList.size(); i++){
                if(personList.get(i).getUserName().equals("${ENV_UN_Admin}")){
                    return ResponseEntity.ok("MasterAdmin already exists.");
                }
            }
        }
        PersonDTO masterAdmin = new PersonDTO();
        masterAdmin.setUserName("${ENV_UN_Admin}");
        masterAdmin.setPassWord("${ENV_PW_Admin}");
        masterAdmin.setLoginRole(LoginRole.ADMIN);
        saveAdmin(masterAdmin);
        return ResponseEntity.status(HttpStatus.CREATED).body("MasterAdmin has been successfully created.");
    }
    @PostMapping("/admin")
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveAdmin(@RequestBody PersonDTO person){
        Person addAdmin = Person.personBuilder()
                .userName(person.getUserName())
                .passWord(person.getPassWord())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .contactDetails(person.getContactDetails())
                .addresses(person.getAddresses())
                .loginRole(person.getLoginRole())
                .gpsData(person.getGpsData())
                .build();
        return personService.saveAdmin(addAdmin);
    }
    @PostMapping("/editor")
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveEditor(@RequestBody PersonDTO  person){
        Person addEditor = Person.personBuilder()
                .userName(person.getUserName())
                .passWord(person.getPassWord())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .contactDetails(person.getContactDetails())
                .addresses(person.getAddresses())
                .loginRole(person.getLoginRole())
                .gpsData(person.getGpsData())
                .build();
        return personService.saveEditor(addEditor);
    }
    @PostMapping("/user")
    //@PreAuthorize("hasAuthority('LoginRole=ADMIN')")
    public String saveUser(@RequestBody PersonDTO person){
        Person addUser = Person.personBuilder()
                .userName(person.getUserName())
                .passWord(person.getPassWord())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .contactDetails(person.getContactDetails())
                .addresses(person.getAddresses())
                .loginRole(person.getLoginRole())
                .gpsData(person.getGpsData())
                .build();
        return personService.saveUser(addUser);
    }

    //READ
    @GetMapping("/all")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    @GetMapping("/role")
    public List<Person> getPersonsByRole(@RequestParam("role") LoginRole role){
        return personService.getPersonsByRole(role);
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable String id){
        return personService.getPersonById(id);
    }

    //UPDATE
    @PutMapping
    public String update(@RequestBody PersonDTO person, @RequestParam String id){
        if(!person.getPersonId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID for person does not match the requirements.");
        } else if (getPersonById(id)==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID is not part of the database.");
        }
        Person updatePerson = Person.personBuilder()
                .personId(id)
                .userName(person.getUserName())
                .passWord(person.getPassWord())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .contactDetails(person.getContactDetails())
                .addresses(person.getAddresses())
                .loginRole(person.getLoginRole())
                .gpsData(person.getGpsData())
                .build();
        return personService.update(updatePerson, id);
    }
    //DELETE
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        personService.delete(id);
    }
}
